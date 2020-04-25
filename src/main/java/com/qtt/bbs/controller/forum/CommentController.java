package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.system.AppContext;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Comment;
import com.qtt.bbs.model.entity.Notify;
import com.qtt.bbs.service.CommentService;
import com.qtt.bbs.service.NotifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：CommentController
 * description：TODO
 * date：2020/2/22 15:34
 *
 * @author ：XC
 */
@Api(value = "评论相关操作", tags = "评论相关操作")
@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private NotifyService notifyService;

    @ApiOperation(value = "添加评论", notes = "添加评论")
    @PostMapping("/comment/addComment.do")
    public R addComment(@RequestParam int articleId, @RequestParam String content, @RequestParam String uid,
                        @RequestParam(required = false, defaultValue = "0") int fid,
                        @RequestParam String possessId) {
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setContent(content);
        comment.setAuthorId(uid);
        comment.setCtime(new Date());
        comment.setFatherId(fid);

        // 添加通知消息
        Notify notify = new Notify();
        notify.setType(2);
        notify.setAid(articleId);
        if (comment.getFatherId() == 0) {
            // 2评论
            notify.setAction(2);
        } else {
            // 3回复
            notify.setAction(3);
        }
        notify.setUid(possessId);
        notify.setSenderId(uid);
        notify.setSenderType(1);
        notifyService.addNotifyMessage(notify);

        return commentService.addComment(comment);
    }

    @ApiOperation(value = "查看帖子的所有的评论", notes = "查看帖子的所有的评论")
    @GetMapping("/comment/findByAid.do")
    public R findByAid(@RequestParam int aid) {
        return commentService.selectByAid(aid);
    }

    @ApiOperation(value = "查看帖子的评论的回复", notes = "查看帖子的评论的回复")
    @GetMapping("/comment/findByFid.do")
    public R findByFid(@RequestParam int fid) {
        return commentService.selectByFid(fid);
    }

    @ApiOperation(value = "查看帖子的评论的条数", notes = "查看帖子的评论的条数")
    @GetMapping("/comment/commentNum.do")
    public R commentNum(@RequestParam int aid) {
        return commentService.commentNum(aid);
    }
}
