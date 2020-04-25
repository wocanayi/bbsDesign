package com.qtt.bbs.service.impl;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.dao.forum.VideoDao;
import com.qtt.bbs.model.dto.forum.VideoDto;
import com.qtt.bbs.model.entity.Video;
import com.qtt.bbs.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：VideoServiceImpl
 * description：TODO
 * date：2020/4/6 10:41
 *
 * @author ：XC
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;
    @Override
    public R uploadVideo(Video video) {
        int i = videoDao.uploadVideo(video);
        if (i > 0) {
            return R.ok("上传成功");
        } else {
            return R.fail("上传失败");
        }

    }

    @Override
    public R videoList() {
        List<VideoDto> videoDtos = videoDao.videoList();
        if (videoDtos != null) {
            return R.ok(videoDtos);
        } else {
            return R.fail("暂无内容哟。");
        }
    }

    @Override
    public R getVideoInfo(int id) {
        Video videoInfo = videoDao.getVideoInfo(id);
        if (videoInfo != null) {
            return R.ok(videoInfo);
        } else {
            return R.fail("暂无信息。");
        }
    }
}
