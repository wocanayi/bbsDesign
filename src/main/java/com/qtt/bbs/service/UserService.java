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
 *56	oBFgO5KKbuf7mJtR_xmYnNjIo4Os	Eudemonia	2	Zhengzhou	https://wx.qlogo.cn/mmopen/vi_32/NTzWSNnFhY3QtN1XicnvgUSKXtLuLstBGLh01VYI57HicqZj6S0Dj6vxoibjaKEalnfSoTrnIzUYklanf997USfqw/132		12930
 * @author ：XC
 */
public interface UserService {
    R login(String code);

    R getUserInfo(String data);

    R userDetail(String uid);

    R findByUid(String uid);

    R isExist(String userId);

    R modifyUserInfo(User user);
}
