package com.qtt.bbs.model.dto.forum;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：NotifyDto
 * description：TODO
 * date：2020/4/23 11:18
 *
 * @author ：XC
 */
@Data
public class NotifyDto {
    private int id;
    private int aid;
    private int action;
    private String senderid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ctime;
    private int cid;
    private String avatarurl;
    private String nickname;
}
