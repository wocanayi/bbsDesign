package com.qtt.bbs.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：Like
 * description：TODO
 * date：2020/2/23 12:38
 *
 * @author ：XC
 */
@Data
public class Like {
    private Integer id;
    private Integer aid;
    private String uid;
    private Date ctime;
}
