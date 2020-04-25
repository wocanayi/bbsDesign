package com.qtt.bbs.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：Notify
 * description：TODO
 * date：2020/4/22 15:43
 *
 * @author ：XC
 */
@Data
public class Notify {
    private int id;
    private String content;
    private int type;
    private int aid;
    private int action;
    private String senderId;
    private int senderType;
    private String uid;
    private int isRead;
    private Date ctime;
    private int cid;
}
