package com.qtt.bbs.service.impl;

import com.alibaba.fastjson.JSON;
import com.qtt.bbs.common.util.AesCbcUtil;
import com.qtt.bbs.common.util.HttpUtil;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.dao.forum.ScoreDao;
import com.qtt.bbs.dao.forum.UserDao;
import com.qtt.bbs.dao.forum.UserLoginDao;
import com.qtt.bbs.model.dto.forum.WxLoginDto;
import com.qtt.bbs.model.entity.Score;
import com.qtt.bbs.model.entity.User;
import com.qtt.bbs.model.entity.UserLogin;
import com.qtt.bbs.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Project name：bbsDesign
 * Class name：UserServiceImpl
 * description：TODO
 * date：2020/2/21 20:57
 *
 * @author ：XC
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserLoginDao loginDao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ScoreDao scoreDao;

    @Transactional
    @Override
    public R login(String code) {
        // 1、检验参数title
        if (code != null && code.length() > 0) {
            // 2、组装 微信需要的参数
            String AppId = "wxd79e3bc4c295725f";
            String AppSecret = "09288d3990b4eaf3882dc3b5255373d1";
            String json = restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?appid=" + AppId + "&secret=" + AppSecret + "&js_code=" + code + "&grant_type=authorization_code", String.class);
            // 3、解析结果
            WxLoginDto loginDto = JSON.parseObject(json, WxLoginDto.class);
            if (loginDto.getErrcode() == 0) {
                // 4、解析结果
                // 是不是第一次登陆
                //第一次登录 1.新增用户信息 到数据 2.新用户奖励
                User user = userDao.selectByUid(loginDto.getOpenid());
                int score = 0;
                String smsg;
                if (null != user) {
                    // 老用户
                    // 校验连续登陆的天数 和 每日首次登陆 奖励积分
                    // 现状 登陆成功就奖励10积分
                    score = 10;
                    smsg = "登录奖励";
                    userDao.updateScore(loginDto.getOpenid(), score);
                } else {
                    score = 100;
                    smsg = "注册奖励";
                    // 新用户
                    User user1 = new User();
                    user1.setUid(loginDto.getOpenid());
                    user1.setBalance(score);
                    userDao.insert(user1);
                }
                // 新增登录信息
                UserLogin userLogin = new UserLogin();
                userLogin.setUid(loginDto.getOpenid());
                userLogin.setDays(1);
                userLogin.setCtime(new Date());
                loginDao.save(userLogin);

                // 新增积分
                Score score1 = new Score();
                score1.setCtime(new Date());
                score1.setInfo(smsg);
                score1.setScore(score);
                score1.setUid(loginDto.getOpenid());
                scoreDao.add(score1);
                return R.ok(loginDto.getOpenid());
            } else {
                return R.fail(loginDto.getErrmsg());
            }
        } else {
            return R.fail("code异常！");
        }
    }

    @Override
    public R loginAndUserInfo(String encryptedData, String iv, String code) {
        Map map = new HashMap();
        if (null == code || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return R.fail(map);
        }
        String AppId = "wxd79e3bc4c295725f";
        String AppSecret = "09288d3990b4eaf3882dc3b5255373d1";
        String str = HttpUtil.getJson("https://api.weixin.qq.com/sns/jscode2session?appid=" + AppId + "&secret=" + AppSecret + "&js_code=" + code + "&grant_type=authorization_code");
        try {
            JSONObject json = new JSONObject(str);
            String session_key = json.get("session_key").toString();
            String openid = (String)json.get("openid");
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功！");

                JSONObject userInfoJson = new JSONObject(result);
                User user1 = userDao.selectByUid((String) userInfoJson.get("openId"));
                if (null == user1) {
                    User user = new User();
                    user.setUid((String) userInfoJson.get("openId"));
                    user.setNickName((String) userInfoJson.get("nickName"));
                    user.setGender((Integer) userInfoJson.get("gender"));
                    user.setCity((String) userInfoJson.get("city"));
                    user.setAvatarUrl((String) userInfoJson.get("avatarUrl"));
                    user.setUnionId((String) userInfoJson.get("unionId"));
                    userDao.insert(user);
                }
            } else {
                map.put("status", 0);
                map.put("msg", "解密失败！");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return R.ok(map);
    }
}
