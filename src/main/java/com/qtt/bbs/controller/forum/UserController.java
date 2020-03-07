package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "登录并获取用户信息", notes = "登录并获取用户信息")
    @GetMapping("/user/loginAndUserInfo.do")
    public R loginAndUserInfo(String encryptedData, String iv, @RequestParam String code) {
        return userService.loginAndUserInfo(encryptedData, iv, code);
    }
}
