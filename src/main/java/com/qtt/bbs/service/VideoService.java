package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Video;

/**
 * Project name：bbsDesign
 * Class name：VideoService
 * description：TODO
 * date：2020/4/6 10:41
 *
 * @author ：XC
 */
public interface VideoService {
    R uploadVideo(Video video);
    R videoList();
    R getVideoInfo(int id);
}
