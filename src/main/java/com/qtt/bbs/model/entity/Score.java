package com.qtt.bbs.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：Score
 * description：TODO
 * date：2020/2/21 22:09
 *
 * @author ：XC
 */
@Data
public class Score {
    private Integer id;
    private String uid;
    private Integer score;
    private String info;
    private Date ctime;
}
