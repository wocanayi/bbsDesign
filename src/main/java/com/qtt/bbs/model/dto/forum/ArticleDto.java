package com.qtt.bbs.model.dto.forum;

import lombok.Data;

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
    private Integer origin;
    private int readNum;
    private int likeNum;
    private int commentNum;
}
