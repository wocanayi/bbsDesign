package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.system.AppContext;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Notify;
import com.qtt.bbs.service.FollowService;
import com.qtt.bbs.service.NotifyService;
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

    @Autowired
    private NotifyService notifyService;

    @ApiOperation(value = "加关注", notes = "加关注")
    @PostMapping("/follow/add.do")
    public R addFollow(@RequestParam String uid, String followId) {
        // 添加通知消息
        Notify notify = new Notify();
        notify.setType(2);
        notify.setAction(4);
        notify.setSenderId(uid);
        notify.setSenderType(1);
        notify.setUid(followId);
        notifyService.addNotifyMessage(notify);

        return followService.addFollow(uid, followId);
    }

    @ApiOperation(value = "判断是否关注", notes = "判断是否关注")
    @GetMapping("/follow/isFollowed.do")
    public R isFollowed(@RequestParam String uid, @RequestParam String followId) {
        return followService.idFollowed(uid, followId);
    }

    @ApiOperation(value = "取消关注", notes = "取消关注")
    @DeleteMapping("/follow/del.do")
    public R delFollow(@RequestParam int id) {
        return followService.delFollow(id);
    }

    @ApiOperation(value = "某用户的关注列表", notes = "某用户的关注列表")
    @GetMapping("/follow/allFollows.do")
    public R allFollows(@RequestParam String uid) {
        return followService.allFollows(uid);
    }

    @ApiOperation(value = "某用户的粉丝列表", notes = "某用户的粉丝列表")
    @GetMapping("/follow/allFans.do")
    public R allFans(@RequestParam String followId) {
        return followService.allFans(followId);
    }

    @ApiOperation(value = "某用户的关注数量", notes = "某用户的关注数量")
    @GetMapping("/follow/followNums.do")
    public R followNums(@RequestParam String uid) {
        return followService.followNums(uid);
    }

    @ApiOperation(value = "某用户的粉丝数量", notes = "某用户的粉丝数量")
    @GetMapping("/follow/fansNums.do")
    public R fansNums(@RequestParam String followId) {
        return followService.fansNums(followId);
    }
}
