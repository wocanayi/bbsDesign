package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Comment;

/**
 * Project name：bbsDesign
 * Class name：CommentService
 * description：TODO
 * date：2020/2/22 18:26
 *
 * @author ：XC
 */
public interface CommentService {
    R addComment(Comment comment);
    R selectByAid(int aid);
    R selectByFid(int fid);
    R commentNum(int aid);
}
