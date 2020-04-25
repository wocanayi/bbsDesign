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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
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
    public R createType(HttpServletRequest request, @RequestParam String uid, @RequestParam String typename,
                        @RequestParam String info, @RequestParam String reason) {
        String URL = "http://localhost:8081/images/";
        ArticleType articleType = new ArticleType();
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("img");
        assert file != null;
        String fileName = FileNameUtil.getFileName(file.getOriginalFilename());
        try {
            file.transferTo(new File("D:\\image", fileName));
            articleType.setImageUrl(URL + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        articleType.setInfo(info);
        articleType.setTypeName(typename);
        articleType.setUid(uid);
        articleType.setReason(reason);
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

    @ApiOperation(value = "我加入的社区", notes = "我加入的社区")
    @GetMapping("/type/joinedTypes.do")
    public R joinedTypes(@RequestParam String uid) {
        return typeService.joinedTypes(uid);
    }

    @ApiOperation(value = "我创建的社区", notes = "我创建的社区")
    @GetMapping("/type/createdTypes.do")
    public R createdTypes(@RequestParam String uid) {
        return typeService.createdTypes(uid);
    }

    @ApiOperation(value = "根据帖子类型查找帖子", notes = "根据帖子类型查找帖子")
    @GetMapping("/type/getArticlesByType.do")
    public R getArticlesByType(@RequestParam int id) {
        return typeService.getArticlesByType(id);
    }
}
