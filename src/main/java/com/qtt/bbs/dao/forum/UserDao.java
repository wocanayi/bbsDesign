package com.qtt.bbs.dao.forum;

import com.qtt.bbs.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Project name：bbsDesign
 * Class name：UserDao
 * description：TODO
 * date：2020/2/21 21:01
 *
 * @author ：XC
 */
@Repository
public interface UserDao {
    User selectByUid(String openid);

    int updateScore(@Param("uid") String openid, @Param("score") int score);

    int insert(User user);
}
