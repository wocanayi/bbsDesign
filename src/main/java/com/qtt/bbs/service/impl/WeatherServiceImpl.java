package com.qtt.bbs.service.impl;

import com.alibaba.fastjson.JSON;
import com.qtt.bbs.common.util.DateUtil;
import com.qtt.bbs.common.util.HttpUtil;
import com.qtt.bbs.common.util.RedissionUtil;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.config.RedisKeyConfig;
import com.qtt.bbs.config.SystemConfig;
import com.qtt.bbs.dao.ribon.WeatherDao;
import com.qtt.bbs.model.dto.robin.JdWeatherDto;
import com.qtt.bbs.model.dto.robin.WeatherDto;
import com.qtt.bbs.model.entity.Weather;
import com.qtt.bbs.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：WeatherServiceImpl
 * description：TODO
 * date：2020/2/19 14:06
 *
 * @author ：XC
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherDao weatherDao;

    @Override
    public R queryToday(String city) {
        // 1、检索Redis是否存在数据
        /*if (RedissionUtil.checkHash(RedisKeyConfig.KEY_WEATHER_TODAY, city)) {
            // 存在就获取数据
            String str = RedissionUtil.getHashVal(RedisKeyConfig.KEY_WEATHER_TODAY, city);
            // 转换为对象 返回
            return R.ok(JSON.parseObject(str, Weather.class));
        } else {*/
            // Redis没有数据
            // 2、查询数据库
            Weather weather = weatherDao.getByCityAndCdate(city, new Date());
            if (null != weather) {
                // 这个城市的今日天气信息存在
                // 同步数据到redis 需要校验是不是第一次 第一次设置有效期、
                /*if (!RedissionUtil.checkKey(RedisKeyConfig.KEY_WEATHER_TODAY)) {
                    // 创建并设置有效期 当日有效 24-now
                    RedissionUtil.saveHash(RedisKeyConfig.KEY_WEATHER_TODAY, city, JSON.toJSONString(weather), DateUtil.getSeconds());
                } else {
                    RedissionUtil.saveHash(RedisKeyConfig.KEY_WEATHER_TODAY, city, JSON.toJSONString(weather));
                }*/
                return R.ok(weather);
            } else {
                // 数据库不存在
                // 请求网络接口
                String json = HttpUtil.getJson(SystemConfig.WEATHER_URL + city);
                // 检验是否获取结果
                if (null != json) {
                    // 解析结果
                    JdWeatherDto dto = JSON.parseObject(json, JdWeatherDto.class);
                    if (dto.getCode() == 10000 && dto.getResult().getStatus() == 0) {
                        WeatherDto weatherDto = dto.getResult().getResult();
                        Weather weather1 = new Weather();
                        weather1.setCdate(weatherDto.getDate());
                        weather1.setCity(weatherDto.getCity());
                        weather1.setCitycode(weatherDto.getCitycode());
                        weather1.setTemphigh(weatherDto.getTemphigh());
                        weather1.setTemplow(weatherDto.getTemplow());
                        weather1.setWeather(weatherDto.getWeather());
                        weather1.setWeek(weatherDto.getWeek());
                        weather1.setWinddirect(weatherDto.getWinddirect());
                        weather1.setWindpower(weatherDto.getWindpower());
                        weather1.setCtime(new Date());
                        // 存储到Mysql
                        //weatherDao.save(weather1);
                        // 再将数据存储到Redis
                        // 这个城市的今日天气信息存在
                        // 同步数据到Redis需要校验是不是第一次 第一次设置有效期
                        /*if (!RedissionUtil.checkKey(RedisKeyConfig.KEY_WEATHER_TODAY)) {
                            //创建并设置有效期  当日有效  24-now
                            RedissionUtil.saveHash(RedisKeyConfig.KEY_WEATHER_TODAY,
                                    city, JSON.toJSONString(weather1), DateUtil.getSeconds());
                        } else {
                            RedissionUtil.saveHash(RedisKeyConfig.KEY_WEATHER_TODAY, city, JSON.toJSONString(weather1));
                        }*/
                        return R.ok(weather1);
                    }
                }
            }
       // }
        return R.fail("城市异常！");
    }
}
