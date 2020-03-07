package com.qtt.bbs.service.impl;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.dao.forum.ImageDao;
import com.qtt.bbs.model.entity.Image;
import com.qtt.bbs.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project name：bbsDesign
 * Class name：ImageServiceImpl
 * description：TODO
 * date：2020/2/27 13:24
 *
 * @author ：XC
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDao imageDao;

    @Override
    public R uploadPictures(Image image) {
        if (imageDao.uploadPictures(image) > 0) {
            return R.ok("上传成功！");
        } else {
            return R.fail("上传失败");
        }
    }
}