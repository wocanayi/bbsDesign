package com.qtt.bbs.service.impl;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.dao.forum.CommentDao;
import com.qtt.bbs.model.dto.forum.CommentDto;
import com.qtt.bbs.model.entity.Comment;
import com.qtt.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：CommentServiceImpl
 * description：TODO
 * date：2020/2/22 18:26
 *
 * @author ：XC
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public R addComment(Comment comment) {
        if (commentDao.addComment(comment) > 0) {
            return R.ok("成功！");
        } else {
            return R.fail("评论失败！");
        }
    }

    @Override
    public R selectByAid(int aid) {
        List<CommentDto> commentList = commentDao.selectByAid(aid);
        if (commentList == null) {
            return R.fail("暂无评论！");
        } else {
            return R.ok(commentList);
        }
    }

    @Override
    public R selectByFid(int fid) {
        List<CommentDto> commentList = commentDao.findByFatherId(fid);
        if (commentList == null) {
            return R.fail("暂无评论！");
        } else {
            return R.ok(commentList);
        }
    }

    @Override
    public R commentNum(int aid) {
        int i = commentDao.commentNum(aid);
        return R.ok(i);
    }
}
