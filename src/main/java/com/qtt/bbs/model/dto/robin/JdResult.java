package com.qtt.bbs.model.dto.robin;

import lombok.Data;

/**
 * Project name：NzCloudRobin
 * Class name：JdResult
 * description：TODO
 * date：2020/2/15 14:19
 *
 * @author ：XC
 */
@Data
public class JdResult {
    private int status;
    private String msg;
    private WeatherDto result;
}
