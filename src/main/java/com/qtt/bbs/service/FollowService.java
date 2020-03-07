package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Follow;

/**
 * Project name：bbsDesign
 * Class name：FollowService
 * description：TODO
 * date：2020/2/23 15:20
 *
 * @author ：XC
 */
public interface FollowService {
    R addFollow(Follow follow);

    R delFollow(Follow follow);

    R allFollows(String uid);
}
