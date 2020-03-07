package com.qtt.bbs.dao.forum;

import com.qtt.bbs.model.dto.forum.CommentDto;
import com.qtt.bbs.model.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：CommentDao
 * description：TODO
 * date：2020/2/21 20:43
 *
 * @author ：XC
 */
@Repository
public interface CommentDao {
    int addComment(Comment comment);

    List<CommentDto> selectByAid(int aid);

    List<CommentDto> findByFatherId(int fid);
}
