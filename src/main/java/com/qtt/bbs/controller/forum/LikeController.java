package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Like;
import com.qtt.bbs.service.LikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Project name：bbsDesign
 * Class name：LikeController
 * description：TODO
 * date：2020/2/22 15:34
 *
 * @author ：XC
 */
@Api(value = "点赞相关接口", tags = "点赞相关接口")
@RestController
@CrossOrigin
public class LikeController {

    @Autowired
    private LikeService likeService;

    @ApiOperation(value = "点赞或取消点赞", notes = "点赞或取消点赞")
    @PostMapping("/like/addDelLike.do")
    public R addDelLike(@RequestBody Like like) {
        return likeService.addDelLike(like);
    }

    @ApiOperation(value = "某篇帖子的点赞数", notes = "某篇帖子的点赞数")
    @GetMapping("/like/likeNum.do")
    public R likeNum(@RequestParam int aid) {
        return likeService.likeNum(aid);
    }
}
