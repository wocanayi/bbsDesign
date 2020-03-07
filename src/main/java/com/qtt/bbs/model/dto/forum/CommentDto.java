package com.qtt.bbs.model.dto.forum;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：CommentDto
 * description：TODO
 * date：2020/2/22 22:04
 *
 * @author ：XC
 */
@Data
public class CommentDto {
    private Integer id;
    private Integer articleId;
    private String uid;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ctime;
    private String authorId;
    private Integer fatherId;
    private String nickname;
    private String avatarurl;
}
