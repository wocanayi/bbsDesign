package com.qtt.bbs.dao.forum;

import com.qtt.bbs.model.dto.forum.VideoDto;
import com.qtt.bbs.model.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：VideoDao
 * description：TODO
 * date：2020/4/6 10:42
 *
 * @author ：XC
 */
@Repository
public interface VideoDao {

    int uploadVideo(Video video);
    List<VideoDto> videoList();
    Video getVideoInfo(int id);
}
