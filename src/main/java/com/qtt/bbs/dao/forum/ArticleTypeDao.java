package com.qtt.bbs.dao.forum;

import com.qtt.bbs.model.entity.ArticleType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：ArticleTypeDao
 * description：TODO
 * date：2020/2/20 20:13
 *
 * @author ：XC
 */
@Repository
public interface ArticleTypeDao {
    int save(ArticleType articleType);
    int delete(int id);
    List<ArticleType> selectAll();
    Long typeNums(int typeId);
    ArticleType findByTypeId(int id);
}
