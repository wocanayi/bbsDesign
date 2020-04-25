package com.qtt.bbs.model.dto.forum;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：VideoList
 * description：TODO
 * date：2020/4/6 18:00
 *
 * @author ：XC
 */
@Data
public class VideoDto {
    private int id;
    private String uid;
    private String nickname;
    private String videoName;
    private String introduce;
    private String videoUrl;
    private int readNum;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ctime;
}
