package com.qtt.bbs.dao.ribon;

import com.qtt.bbs.model.entity.Hito;
import org.springframework.stereotype.Repository;

/**
 * Project name：bbsDesign
 * Class name：HitoDao
 * description：TODO
 * date：2020/2/19 14:47
 *
 * @author ：XC
 */
@Repository
public interface HitoDao {
    int save(Hito hito);
}
