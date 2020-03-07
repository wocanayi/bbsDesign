package com.qtt.bbs.model.dto.robin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Project name：NzCloudRobin
 * Class name：WeatherDto
 * description：TODO
 * date：2020/2/15 14:34
 *
 * @author ：XC
 */
@Data
public class WeatherDto {
    private String city;
    private String citycode;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
    private String week;
    private String weather;
    private Integer temphigh;
    private Integer templow;
    private String winddirect;
    private String windpower;
}
