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
    public R addFollow(Follow follow) {
        int i = followDao.addFollow(follow);
        if (i > 0) {
            return R.ok("关注成功！");
        } else {
            return R.fail("关注失败！");
        }
    }

    @Override
    public R delFollow(Follow follow) {
        int i = followDao.delFollow(follow);
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
}
