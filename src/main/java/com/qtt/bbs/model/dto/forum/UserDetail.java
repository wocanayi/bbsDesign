package com.qtt.bbs.model.dto.forum;

import lombok.Data;

/**
 * Project name：bbsDesign
 * Class name：UserDetail
 * description：TODO
 * date：2020/3/25 20:50
 *
 * @author ：XC
 */
@Data
public class UserDetail {
    private String uid;
    private String avatarUrl;
    private int gender;
    private String nickName;
    private int circleNum; // 圈子数
    private int followNum; // 关注数
    private int fansNum; // 粉丝数
}
