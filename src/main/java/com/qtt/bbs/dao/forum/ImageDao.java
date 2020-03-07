package com.qtt.bbs.dao.forum;

import com.qtt.bbs.model.entity.Image;
import org.springframework.stereotype.Repository;

/**
 * Project name：bbsDesign
 * Class name：ImageDao
 * description：TODO
 * date：2020/2/27 13:25
 *
 * @author ：XC
 */
@Repository
public interface ImageDao {
    int uploadPictures(Image image);
}
