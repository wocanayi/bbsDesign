package com.qtt.bbs.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：Weather
 * description：TODO
 * date：2020/2/19 13:56
 *
 * @author ：XC
 */
@Data
public class Weather {
    private Integer id;
    private String city;
    private String citycode;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cdate;
    private String week;
    private String weather;
    private Integer temphigh;
    private Integer templow;
    private String winddirect;
    private String windpower;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ctime;
}
