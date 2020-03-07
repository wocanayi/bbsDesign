package com.qtt.bbs.model.dto.forum;

import lombok.Data;

/**
 * Project name：bbsDesign
 * Class name：LikeDto
 * description：TODO
 * date：2020/2/23 12:39
 *
 * @author ：XC
 */
@Data
public class LikeDto {
    private Integer id;
    private Integer aid;
    private String uid;
    private String nickname;
    private String avatarurl;
}
