package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Follow;
import com.qtt.bbs.service.FollowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Project name：bbsDesign
 * Class name：Follow
 * description：TODO
 * date：2020/2/23 15:19
 *
 * @author ：XC
 */
@Api(value = "关注相关操作", tags = "关注相关操作")
@RestController
@CrossOrigin
public class FollowController {

    @Autowired
    private FollowService followService;

    @ApiOperation(value = "加关注", notes = "加关注")
    @PostMapping("/follow/add.do")
    public R addFollow(@RequestBody Follow follow) {
        return followService.addFollow(follow);
    }

    @ApiOperation(value = "取消关注", notes = "取消关注")
    @DeleteMapping("/follow/del.do")
    public R delFollow(@RequestBody Follow follow) {
        return followService.delFollow(follow);
    }

    @ApiOperation(value = "某用户的关注列表", notes = "某用户的关注列表")
    @GetMapping("/follow/allFollows.do")
    public R allFollows(@RequestParam String uid) {
        return followService.allFollows(uid);
    }
}
