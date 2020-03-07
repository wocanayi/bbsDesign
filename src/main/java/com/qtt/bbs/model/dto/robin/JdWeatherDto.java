package com.qtt.bbs.model.dto.robin;

import lombok.Data;

/**
 * Project name：NzCloudRobin
 * Class name：JdWeatherDto
 * description：TODO
 * date：2020/2/15 14:37
 *
 * @author ：XC
 */
@Data
public class JdWeatherDto {
    private Integer code;
    private String msg;
    private JdResult result;
}
