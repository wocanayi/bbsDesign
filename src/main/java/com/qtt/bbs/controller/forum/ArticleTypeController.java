package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.ArticleType;
import com.qtt.bbs.service.ArticleTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Project name：bbsDesign
 * Class name：ArticleTypeController
 * description：TODO
 * date：2020/2/20 20:30
 *
 * @author ：XC
 */
@Api(value = "帖子类型相关操作", tags = "帖子类型相关操作")
@RestController
@CrossOrigin
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService typeService;

    @ApiOperation(value = "添加帖子类型", notes = "添加帖子类型")
    @PostMapping("/type/add.do")
    public R save(@RequestBody ArticleType articleType) {
        return typeService.save(articleType);
    }

    @ApiOperation(value = "删除帖子类型", notes = "删除帖子类型")
    @DeleteMapping("/type/delete.do")
    public R delete(@RequestParam int id) {
        return typeService.delete(id);
    }

    @ApiOperation(value = "查看所有帖子类型", notes = "查看所有帖子类型")
    @GetMapping("/type/selectAll.do")
    public R selectAll() {
        return typeService.selectAll();
    }
}
