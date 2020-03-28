package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.dto.forum.UserDto;
import com.qtt.bbs.model.entity.User;

import java.util.Map;

/**
 * Project name：bbsDesign
 * Class name：UserService
 * description：TODO
 * date：2020/2/21 20:57
 *
 * @author ：XC
 */
public interface UserService {
    R login(String code);

    R getUserInfo(String data);

    R userDetail(String uid);

    R isExist(String userId);
}
