package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Image;

/**
 * Project name：bbsDesign
 * Class name：ImageService
 * description：TODO
 * date：2020/2/27 13:24
 *
 * @author ：XC
 */
public interface ImageService {
    R uploadPictures(Image image);
}
