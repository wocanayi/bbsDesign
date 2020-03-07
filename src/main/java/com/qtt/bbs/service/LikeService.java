package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Like;

/**
 * Project name：bbsDesign
 * Class name：LikeService
 * description：TODO
 * date：2020/2/23 12:26
 *
 * @author ：XC
 */
public interface LikeService {
    R addDelLike(Like like);
    R likeNum(int aid);
}
