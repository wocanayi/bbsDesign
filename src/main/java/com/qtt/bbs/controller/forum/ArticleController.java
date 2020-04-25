package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.util.FileNameUtil;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Article;
import com.qtt.bbs.service.ArticleService;
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
    private MultipartHttpServletRequest multipartHttpServletRequest;

    @ApiOperation(value = "发帖", notes = "发帖")
    @PostMapping("/article/post.do")
    public R post(HttpServletRequest request, @RequestParam String uid, @RequestParam String content, @RequestParam(defaultValue = "0", required = false) int tid) {
        Article article = new Article();
        String URL = "http://localhost:8081/images/";
        //String path = "";
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("imageFile");
        System.out.println("进入方法..." + file);
        assert file != null;
        String fileName = FileNameUtil.getFileName(file.getOriginalFilename());
        String newName = URL + fileName;
        try {
            file.transferTo(new File("D:\\image", fileName));
            //path += newName + ",";
        } catch (IOException e) {
            e.printStackTrace();
        }
        article.setImgUrl(newName);
        article.setTitle("无题");
        article.setContent(content);
        article.setTypeId(tid);
        article.setUid(uid);
        article.setOrigin(0);
        return articleService.save(article);

    }

    @ApiOperation(value = "发帖纯文本", notes = "发帖纯文本")
    @PostMapping("/article/postText.do")
    public R post(@RequestParam String uid, @RequestParam String content, @RequestParam(defaultValue = "0", required = false) int tid) {
        Article article = new Article();
        article.setUid(uid);
        article.setContent(content);
        article.setTypeId(tid);
        article.setTitle("单文本");
        article.setOrigin(0);
        return articleService.save(article);
    }

   /* @ApiOperation(value = "发帖上传多张图片", notes = "发帖上传多张图片")
    @PostMapping("/article/post.do")
    public R post(@RequestParam String uid, @RequestParam String content, @RequestParam MultipartFile[] files) {
        Article article = new Article();
        String path = "";
        String URL = "http://localhost:8081/images/";
        System.out.println(files.length + "__________files length");
        if (files.length != 0) {
            for (MultipartFile file : files) {
                System.out.println(file.getOriginalFilename() + "__________files");
                String fileName = FileNameUtil.getFileName(file.getOriginalFilename());
                String newName = URL + fileName;
                try {
                    file.transferTo(new File("D:\\image", fileName));
                    path += newName + ",";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            article.setImgUrl(path);
            article.setCtime(new Date());
            article.setTitle("无题");
            article.setContent(content);
            article.setUid(uid);
            article.setOrigin(0);
        }
        return articleService.save(article);
    }*/

    /*@ApiOperation(value = "发帖上传单张图片", notes = "发帖上传单张图片")
    @PostMapping("/article/post.do")
    public R post(HttpServletRequest request) {
        Article article = new Article();
        String uid = request.getParameter("uid");
        String content = request.getParameter("content");
        // String path = "";
        String URL = "http://localhost:8081/images/";

        if (request.getParameter("imageFile") != null) {
            MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
            MultipartFile file = req.getFile("imageFile");
            assert file != null;
            System.out.println(file.getOriginalFilename() + "__________files");
            String fileName = FileNameUtil.getFileName(file.getOriginalFilename());
            String newName = URL + fileName;
            try {
                file.transferTo(new File("D:\\image", fileName));
                //path += newName + ",";
            } catch (IOException e) {
                e.printStackTrace();
            }
            article.setImgUrl(newName);
        }
        article.setCtime(new Date());
        article.setTitle("无题");
        article.setContent(content);
        article.setUid(uid);
        article.setOrigin(0);
        return articleService.save(article);
    }*/

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
        return articleService.selectFollow(uid);
    }

    @ApiOperation(value = "查询推荐的帖子", notes = "查询推荐的帖子")
    @GetMapping("/article/selectTop.do")
    public R selectTop() {
        return articleService.selectTop();
    }

    @ApiOperation(value = "根据类型查找帖子", notes = "根据类型查找帖子")
    @GetMapping("/article/findByType.do")
    public R findByType(@RequestParam int typeId) {
        return articleService.findByType(typeId);
    }

    @ApiOperation(value = "根据标题或内容模糊查询", notes = "根据标题或内容模糊查询")
    @GetMapping("/article/fuzzySearch.do")
    public R fuzzySearch(@RequestParam(required = false) String title, @RequestParam(required = false) String content) {
        return articleService.fuzzySearch(title, content);
    }

    @ApiOperation(value = "获取帖子图片列表", notes = "获取帖子图片列表")
    @GetMapping("/article/imgList.do")
    public R imgList(@RequestParam String uid) {
        return articleService.imgList(uid);
    }

    @ApiOperation(value = "我点赞的帖子", notes = "我点赞的帖子")
    @GetMapping("/article/likedArticle.do")
    public R likedArticle(@RequestParam String uid) {
        return articleService.likedArticle(uid);
    }

    @ApiOperation(value = "帖子设置顶", notes = "帖子设置顶")
    @GetMapping("/article/setTop.do")
    public R setTop(@RequestParam int aid) {
        return articleService.setTop(aid);
    }
}
