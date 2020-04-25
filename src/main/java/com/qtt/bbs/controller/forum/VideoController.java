package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.util.FileNameUtil;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Video;
import com.qtt.bbs.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Project name：bbsDesign
 * Class name：VideoController
 * description：TODO
 * date：2020/4/6 10:37
 *
 * @author ：XC
 */
@Api(value = "视频相关操作", tags = "视频相关操作")
@RestController
@CrossOrigin
public class VideoController {
    @Autowired
    private VideoService videoService;

    @ApiOperation(value = "上传视频", notes = "上传视频")
    @PostMapping("/video/uploadVideo.do")
    public R uploadVideo(@RequestParam String uid, @RequestParam String name, @RequestParam String intro, @RequestParam MultipartFile file) {
        Video video = new Video();
        String URL = "http://localhost:8081/images/";
        String fileName = FileNameUtil.getFileName(file.getOriginalFilename());
        try {
            file.transferTo(new File("D:\\image", fileName));
            video.setVideoUrl(URL + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        video.setVideoName(name);
        video.setIntroduce(intro);
        video.setUid(uid);
        return videoService.uploadVideo(video);
    }

    @ApiOperation(value = "获取视频列表", notes = "获取视频列表")
    @GetMapping("/video/videoList.do")
    public R videoList() {
        return videoService.videoList();
    }

    @ApiOperation(value = "获取某个视频详细信息", notes = "获取某个视频详细信息")
    @GetMapping("/video/getVideoInfo.do")
    public R getVideoInfo(@RequestParam int id) {
        return videoService.getVideoInfo(id);
    }
}
