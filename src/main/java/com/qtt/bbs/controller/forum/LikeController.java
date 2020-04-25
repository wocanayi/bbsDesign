package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.system.AppContext;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Like;
import com.qtt.bbs.model.entity.Notify;
import com.qtt.bbs.service.ArticleService;
import com.qtt.bbs.service.LikeService;
import com.qtt.bbs.service.NotifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：LikeController
 * description：TODO
 * date：2020/2/22 15:34
 *
 * @author ：XC
 */
@Api(value = "点赞相关接口", tags = "点赞相关接口")
@RestController
@CrossOrigin
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private NotifyService notifyService;

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "点赞或取消点赞", notes = "点赞或取消点赞")
    @PostMapping("/like/addDelLike.do")
    public R addDelLike(@RequestParam int aid, @RequestParam String uid, @RequestParam String possessId) {
        Like like = new Like();
        like.setAid(aid);
        like.setUid(uid);
        like.setCtime(new Date());

        // 添加通知消息
        Notify notify = new Notify();
        notify.setType(2);
        notify.setAid(aid);
        notify.setAction(1);
        notify.setSenderId(uid);
        notify.setSenderType(1);
        notify.setUid(possessId);
        notifyService.addNotifyMessage(notify);

        return likeService.addDelLike(like);
    }

    @ApiOperation(value = "某篇帖子的点赞数", notes = "某篇帖子的点赞数")
    @DeleteMapping("/like/delMyLike.do")
    public R delMyLike(@RequestParam int aid) {
        return likeService.delMyLike(aid);
    }

    @ApiOperation(value = "某篇帖子的点赞数", notes = "某篇帖子的点赞数")
    @GetMapping("/like/likeNum.do")
    public R likeNum(@RequestParam int aid) {
        return likeService.likeNum(aid);
    }

    @ApiOperation(value = "判断是否点过赞", notes = "判断是否点过赞")
    @GetMapping("/like/isLiked.do")
    public R isLiked(@RequestParam int aid, @RequestParam String uid) {
        return likeService.isLiked(aid, uid);
    }
}
