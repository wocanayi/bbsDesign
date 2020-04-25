package com.qtt.bbs.service.impl;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.dao.forum.FollowDao;
import com.qtt.bbs.model.dto.forum.FollowDto;
import com.qtt.bbs.model.entity.Follow;
import com.qtt.bbs.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：FollowServiceImpl
 * description：TODO
 * date：2020/2/23 15:20
 *
 * @author ：XC
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowDao followDao;

    @Override
    public R addFollow(String uid, String followId) {
        Follow follow = new Follow();
        follow.setUid(uid);
        follow.setFollowId(followId);
        int i = followDao.addFollow(follow);
        if (i > 0) {
            return R.ok("关注成功！");
        } else {
            return R.fail("关注失败！");
        }
    }

    @Override
    public R delFollow(int id) {
        int i = followDao.delFollow(id);
        if (i > 0) {
            return R.ok("取消成功！");
        } else {
            return R.fail("取消失败！");
        }
    }

    @Override
    public R allFollows(String uid) {
        List<FollowDto> followDtos = followDao.allFollows(uid);
        if (null != followDtos) {
            return R.ok(followDtos);
        } else {
            return R.fail("暂无关注！");
        }
    }

    @Override
    public R idFollowed(String uid, String followId) {
        int followed = followDao.isFollowed(uid, followId);
        if (followed > 0) {
            return R.ok(true);
        } else {
            return R.fail(false);
        }
    }

    @Override
    public R followNums(String uid) {
        int i = followDao.followNums(uid);
        return R.ok(i);
    }

    @Override
    public R fansNums(String followId) {
        int i = followDao.fansNums(followId);
        return R.ok(i);
    }

    @Override
    public R allFans(String followId) {
        List<FollowDto> allFans = followDao.allFans(followId);
        if (null != allFans) {
            return R.ok(allFans);
        } else {
            return R.fail("暂无粉丝！");
        }
    }
}
