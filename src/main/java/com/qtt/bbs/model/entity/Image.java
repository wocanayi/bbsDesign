package com.qtt.bbs.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：Image
 * description：TODO
 * date：2020/2/18 22:46
 *
 * @author ：XC
 */
@Data
public class Image {
    private Integer id;
    private String imgUrl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ctime;
    private String info;
    private Integer aid;
}
