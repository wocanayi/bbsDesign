package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.dto.forum.ArticleDto;
import com.qtt.bbs.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Project name：bbsDesign
 * Class name：ArticleController
 * description：TODO
 * date：2020/2/20 12:41
 *
 * @author ：XC
 */
@Api(value = "帖子操作相关接口", tags = "帖子操作相关接口")
@RestController
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "发帖", notes = "发帖")
    @PostMapping("/article/post.do")
    public R post(@RequestBody ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @ApiOperation(value = "删帖", notes = "删帖")
    @DeleteMapping("/article/delete.do")
    public R delPost(@RequestParam int id) {
        return articleService.delete(id);
    }

    @ApiOperation(value = "根据id查找帖子并添加帖子浏览量", notes = "根据id查找帖子并添加帖子浏览量")
    @GetMapping("/article/findById.do")
    public R findById(@RequestParam int id) {
        return articleService.findById(id);
    }

    @ApiOperation(value = "查找帖子带分页", notes = "查找帖子带分页")
    @GetMapping("/article/findByPage.do")
    public R getArticleByPage(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        return articleService.getArticleByPage(page, pageSize);
    }

    @ApiOperation(value = "查询某用户发的帖子", notes = "查询某用户发的帖子")
    @GetMapping("/article/findByUid.do")
    public R findByUid(@RequestParam String uid) {
        return articleService.findByUid(uid);
    }

    @ApiOperation(value = "查找所有帖子", notes = "查找所有帖子")
    @GetMapping("/article/selectAll.do")
    public R selectAll() {
        return articleService.selectAll();
    }

    @ApiOperation(value = "查询关注博主的帖子", notes = "查询关注博主的帖子")
    @GetMapping("/article/selectFollow.do")
    public R selectFollow(@RequestParam String uid) {
        return articleService.findByUid(uid);
    }

    @ApiOperation(value = "根据标题或内容模糊查询", notes = "根据标题或内容模糊查询")
    @GetMapping("/article/fuzzySearch.do")
    public R fuzzySearch(@RequestParam(required = false) String title, @RequestParam(required = false) String content) {
        return articleService.fuzzySearch(title, content);
    }
}
