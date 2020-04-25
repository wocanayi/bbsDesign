package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.User;
import com.qtt.bbs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Project name：bbsDesign
 * Class name：UserController
 * description：TODO
 * date：2020/2/21 20:56
 *
 * @author ：XC
 */
@Api(value = "用户相关操作", tags = "用户相关操作")
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录", notes = "登录")
    @GetMapping("/user/login.do")
    public R login(@RequestParam String code) {
        return userService.login(code);
    }

    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @GetMapping("/user/userDetail.do")
    public R userDetail(@RequestParam String userId) {
        return userService.userDetail(userId);
    }

    @ApiOperation(value = "查询用户个人信息", notes = "查询用户个人信息")
    @GetMapping("/user/findByUid.do")
    public R findByUid(@RequestParam String uid) {
        return userService.findByUid(uid);
    }

    @ApiOperation(value = "是否存在用户信息", notes = "是否存在用户信息")
    @GetMapping("/user/isExist.do")
    public R isExist(@RequestParam String userId) {
        return userService.isExist(userId);
    }

    @ApiOperation(value = "保存用户信息", notes = "保存用户信息")
    @PostMapping("/user/addUserInfo.do")
    public R getUserInfo(@RequestParam String user) {
        System.out.println("____Controller_____" + user);
        return userService.getUserInfo(user);
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @PutMapping("/user/modifyUserInfo.do")
    public R modifyUserInfo(@RequestParam String uid, @RequestParam(required = false) String nickName,
                            @RequestParam(required = false) String gender, @RequestParam(required = false) String city) {
        User user = new User();
        user.setUid(uid);
        user.setNickName(nickName);
        if ("男".equals(gender)) {
            user.setGender(1);
        } else {
            user.setGender(2);
        }
        user.setCity(city);
        return userService.modifyUserInfo(user);
    }
}
