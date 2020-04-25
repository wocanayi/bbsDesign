package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.util.FileNameUtil;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Image;
import com.qtt.bbs.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Project name：bbsDesign
 * Class name：ImageController
 * description：TODO
 * date：2020/2/27 13:22
 *
 * @author ：XC
 */
@Api(value = "帖子图片相关接口", tags = "帖子图片相关接口")
@RestController
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageService imageService;

    @ApiOperation(value = "上传图片", notes = "上传图片")
    @PostMapping("/image/uploadPictures.do")
    public R uploadPictures(Image image, MultipartFile file) {
        String URL = "http://localhost:8081/images/";
        String fileName = FileNameUtil.getFileName(file.getOriginalFilename());
        try {
            file.transferTo(new File("D:\\image", fileName));
            image.setImgUrl(URL + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageService.uploadPictures(image);
    }
}
