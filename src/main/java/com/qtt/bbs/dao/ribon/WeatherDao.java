package com.qtt.bbs.dao.ribon;

import com.qtt.bbs.model.entity.Weather;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：WeatherDao
 * description：TODO
 * date：2020/2/19 14:04
 *
 * @author ：XC
 */
@Repository
public interface WeatherDao {
    Weather getByCityAndCdate(String city, Date cdate);
    int save(Weather weather);
}
