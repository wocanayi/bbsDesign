package com.qtt.bbs.dao.forum;

import com.qtt.bbs.model.entity.UserLogin;
import org.springframework.stereotype.Repository;

import java.io.LineNumberReader;
import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：UserLoginDao
 * description：TODO
 * date：2020/2/21 22:39
 *
 * @author ：XC
 */
@Repository
public interface UserLoginDao {
    int save(UserLogin userLogin);
    List<UserLogin> selectAll(String uid);
}
