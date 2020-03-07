package com.qtt.bbs.controller.robin;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.service.HitoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project name：bbsDesign
 * Class name：HitoController
 * description：TODO
 * date：2020/2/19 15:46
 *
 * @author ：XC
 */
@Api(value = "一言", tags = "一言")
@RestController
public class HitoController {

    @Autowired
    private HitoService hitoService;

    @ApiOperation(value = "随即返回一言", notes = "随即返回一言")
    @GetMapping("/hito/random.do")
    public R random() {
        return hitoService.random();
    }
}
