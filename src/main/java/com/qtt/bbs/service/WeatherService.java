package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;

/**
 * Project name：bbsDesign
 * Class name：WeatherService
 * description：TODO
 * date：2020/2/19 14:06
 *
 * @author ：XC
 */
public interface WeatherService {
    R queryToday(String city);
}
