package com.qtt.bbs.dao.forum;

import com.qtt.bbs.model.entity.Like;
import org.springframework.stereotype.Repository;

/**
 * Project name：bbsDesign
 * Class name：LikeDao
 * description：TODO
 * date：2020/2/23 12:31
 *
 * @author ：XC
 */
@Repository
public interface LikeDao {
    // 点赞
    int addLike(Like like);
    // 查询是否点赞
    Like selectByUid(String uid, int aid);
    // 取消点赞
    int delLike(int id);

    int delMyLike(int aid);
    // 某篇文章的点赞数量
    int likeNum(int aid);

    int isLiked(int aid, String uid);
}
