package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Comment;
import com.qtt.bbs.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "添加评论", notes = "添加评论")
    @PostMapping("/comment/addComment.do")
    public R addComment(@RequestBody Comment comment) {
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
}
