package com.qtt.bbs.model.dto.forum;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：ArticleDto
 * description：TODO
 * date：2020/2/20 12:04
 *
 * @author ：XC
 */
@Data
public class ArticleDto {
    private Integer id;
    private String uid;
    private String avatarUrl;
    private String nickName;
    private Integer typeId;
    private String title;
    private String content;
    private String imgUrl;
    private Integer origin;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ctime;
    private int readNum;
    private int likeNum;
    private int commentNum;
}
