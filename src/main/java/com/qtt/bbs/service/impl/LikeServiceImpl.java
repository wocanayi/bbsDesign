package com.qtt.bbs.service.impl;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.dao.forum.ArticleDao;
import com.qtt.bbs.dao.forum.LikeDao;
import com.qtt.bbs.model.entity.Like;
import com.qtt.bbs.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project name：bbsDesign
 * Class name：LikeServiceImpl
 * description：TODO
 * date：2020/2/23 12:27
 *
 * @author ：XC
 */
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDao likeDao;
    @Autowired
    private ArticleDao articleDao;

    @Override
    public R addDelLike(Like like) {
        // 查询该用户是否有点过赞
        Like like1 = likeDao.selectByUid(like.getUid(), like.getAid());
        if (null != like1) {
            // 有点过赞 则取消点赞
            likeDao.delLike(like1.getId());
            // 点赞数减一
            articleDao.reduceLikeNum(like.getAid());
            return R.ok("取消点赞");
        } else {
            // 没点过赞 则点赞
            likeDao.addLike(like);
            // 点赞数加一
            articleDao.addLikeNum(like.getAid());
            return R.ok("点赞");
        }
    }

    @Override
    public R likeNum(int aid) {
        int likeNum = likeDao.likeNum(aid);
        return R.ok(likeNum);
    }

    @Override
    public R isLiked(int aid, String uid) {
        int liked = likeDao.isLiked(aid, uid);
        if (liked > 0) {
            return R.ok(true);
        } else {
            return R.fail(false);
        }
    }

    @Override
    public R delMyLike(int aid) {
        int i = likeDao.delMyLike(aid);
        if (i > 0) {
            return R.ok("取消成功");
        } else {
            return R.fail("fail");
        }
    }
}
