package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.ArticleType;

/**
 * Project name：bbsDesign
 * Class name：ArticleTypeService
 * description：TODO
 * date：2020/2/20 20:23
 *
 * @author ：XC
 */
public interface ArticleTypeService {
    R save(ArticleType articleType);
    R delete(int id);
    R selectAll();
    R selectTypeNums(int typeId);
    R findByTypeId(int id);
    R joinedTypes(String uid);
    R getArticlesByType(int id);
    R createdTypes(String uid);
}
