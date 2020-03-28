package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.util.FileNameUtil;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.ArticleType;
import com.qtt.bbs.service.ArticleTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

    @ApiOperation(value = "添加帖子类型加图片", notes = "添加帖子类型加图片")
    @PostMapping("/type/createType.do")
    public R createType(ArticleType articleType, MultipartFile file) {
        String URL = "http://localhost:8081/images/";
        String fileName = FileNameUtil.getFileName(file.getOriginalFilename());
        try {
            file.transferTo(new File("D:\\image", fileName));
            articleType.setImageUrl(URL + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return typeService.save(articleType);
    }

    @ApiOperation(value = "删除帖子类型", notes = "删除帖子类型")
    @DeleteMapping("/type/delete.do")
    public R delete(@RequestParam int id) {
        return typeService.delete(id);
    }

    @ApiOperation(value = "查看帖子详情信息", notes = "查看帖子详情信息")
    @GetMapping("/type/findByTypeId.do")
    public R findByTypeId(@RequestParam int id) {
        return typeService.findByTypeId(id);
    }

    @ApiOperation(value = "查看所有帖子类型", notes = "查看所有帖子类型")
    @GetMapping("/type/selectAll.do")
    public R selectAll() {
        return typeService.selectAll();
    }

    @ApiOperation(value = "查看帖子类型中的帖子数", notes = "查看帖子类型中的帖子数")
    @GetMapping("/type/articleNums.do")
    public R articleTypeNums(@RequestParam int typeId) {
        return typeService.selectTypeNums(typeId);
    }
}
