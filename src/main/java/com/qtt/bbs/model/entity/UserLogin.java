package com.qtt.bbs.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：UserLogin
 * description：TODO
 * date：2020/2/21 22:10
 *
 * @author ：XC
 */
@Data
public class UserLogin {
    private Integer id;
    private String uid;
    private Integer days;
    private Date ctime;
}
