package com.qtt.bbs;

import com.qtt.bbs.common.util.AesCbcUtil;
import com.qtt.bbs.common.util.HttpUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class BbsDesignApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public Map decodeUserInfo(String encryptedData, String iv, String
                               code) throws JSONException {
        Map map = new HashMap();
        if (null == code || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code不能为空！");
            return map;
        }
        String AppId = "wxd79e3bc4c295725f";
        String AppSecret = "09288d3990b4eaf3882dc3b5255373d1";
        String str = HttpUtil.getJson("https://api.weixin.qq.com/sns/jscode2session?appid=" + AppId + "&secret=" + AppSecret + "&js_code=" + code + "&grant_type=authorization_code");
        JSONObject json = new JSONObject(str);
        String session_key = json.get("session_key").toString();
        String openid = (String)json.get("openid");

        String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
        if (null != result && result.length() > 0) {
            map.put("status", 1);
            map.put("msg", "解密成功！");

            JSONObject userInfoJSON = new JSONObject(result);
            Map userInfo = new HashMap();
            userInfo.put("openId", userInfoJSON.get("openId"));
            userInfo.put("nickName", userInfoJSON.get("nickName"));
            userInfo.put("gender", userInfoJSON.get("gender"));
            userInfo.put("city", userInfoJSON.get("city"));
            userInfo.put("province", userInfoJSON.get("province"));
            userInfo.put("country", userInfoJSON.get("country"));
            userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
            userInfo.put("unionId", userInfoJSON.get("unionId"));
            map.put("userInfo", userInfo);
        } else {
            map.put("status", 0);
            map.put("msg", "解密失败！");
        }
        System.out.println("__________________");
        return map;
    }

}
