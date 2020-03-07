package com.qtt.bbs.service.impl;

import com.qtt.bbs.common.vo.R;
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

    @Override
    public R addDelLike(Like like) {
        // 查询该用户是否有点过赞
        Like like1 = likeDao.selectByUid(like.getUid(), like.getAid());
        if (null != like1) {
            // 有点过赞 则取消点赞
            likeDao.delLike(like1.getId());
            return R.ok("取消点赞");
        } else {
            // 没点过赞 则点赞
            likeDao.addLike(like);
            return R.ok("点赞");
        }
    }

    @Override
    public R likeNum(int aid) {
        Integer likeNum = likeDao.likeNum(aid);
        if (null != likeNum) {
            return R.ok(likeNum);
        } else {
            return R.fail();
        }
    }
}
