package com.qtt.bbs.controller.robin;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project name：bbsDesign
 * Class name：WeatherController
 * description：TODO
 * date：2020/2/19 14:23
 *
 * @author ：XC
 */
@Api(value = "天气小组件", tags = "天气小组件")
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @ApiOperation(value = "根据城市查询天气", notes = "根据城市查询天气")
    @GetMapping("/weather/queryCity.do")
    public R queryToday(String city) {
        return weatherService.queryToday(city);
    }
}
