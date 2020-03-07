package com.qtt.bbs.config;

/**
 * Project name：NzCloudRobin
 * Class name：RedisKeyConfig
 * description：TODO
 * date：2020/2/15 14:57
 *
 * @author ：XC
 */
public class RedisKeyConfig {
    // 记录天气查询的Hash类型的Key 做热点数据 有效期：当日有效
    // 字段：城市名称 值：对应城市的当天的天气信息 json 格式 Weather
    public static final String KEY_WEATHER_TODAY = "qtt:weather";
    public static final String KEY_HITOKOTO = "qtt:hito";
}
