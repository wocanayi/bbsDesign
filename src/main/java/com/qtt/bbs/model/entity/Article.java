package com.qtt.bbs.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：Article
 * description：TODO
 * date：2020/2/18 22:31
 *
 * @author ：XC
 */
@Data
public class Article {
    private Integer id;
    private Integer typeId;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ctime;
    private Integer origin;
    private String info;
    private Integer readNum;
    private String uid;
}
