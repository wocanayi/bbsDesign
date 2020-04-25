package com.qtt.bbs.model.dto.forum;

import lombok.Data;

/**
 * Project name：bbsDesign
 * Class name：FollowDto
 * description：TODO
 * date：2020/2/23 15:31
 *
 * @author ：XC
 */
@Data
public class FollowDto {
    private int id;
    private String uid;
    private String followId;
    private String nickname;
    private String avatarurl;
}
