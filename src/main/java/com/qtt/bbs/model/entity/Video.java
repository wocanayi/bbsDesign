package com.qtt.bbs.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：Video
 * description：TODO
 * date：2020/4/6 10:33
 *
 * @author ：XC
 */
@Data
public class Video {
    private int id;
    private String uid;
    private String videoName;
    private String introduce;
    private String videoUrl;
    private int readNum;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ctime;
}
