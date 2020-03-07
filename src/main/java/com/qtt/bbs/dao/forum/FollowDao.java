package com.qtt.bbs.dao.forum;

import com.qtt.bbs.model.dto.forum.FollowDto;
import com.qtt.bbs.model.entity.Follow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：FollowDao
 * description：TODO
 * date：2020/2/23 15:20
 *
 * @author ：XC
 */
@Repository
public interface FollowDao {
    int addFollow(Follow follow);
    int delFollow(Follow follow);
    List<FollowDto> allFollows(String uid);
}
