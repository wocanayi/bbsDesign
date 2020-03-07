package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;

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

    R loginAndUserInfo(String encryptedData, String iv, String code);

}
