package com.qtt.bbs.dao.forum;

import com.qtt.bbs.model.entity.Score;
import org.springframework.stereotype.Repository;

/**
 * Project name：bbsDesign
 * Class name：ScoreDao
 * description：TODO
 * date：2020/2/21 21:03
 *
 * @author ：XC
 */
@Repository
public interface ScoreDao {
    int add(Score score1);
}
