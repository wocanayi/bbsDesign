package com.qtt.bbs.model.dto.forum;

import lombok.Data;

/**
 * Project name：bbsDesign
 * Class name：PostArticle
 * description：TODO
 * date：2020/2/27 20:48
 *
 * @author ：XC
 */
@Data
public class PostArticle {
    private Integer id;
    private String uid;
    private Integer typeId;
    private String title;
    private String content;
    private Integer origin;
    private Integer readNum;
    private String imgUrl;
}
