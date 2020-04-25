package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Article;

/**
 * Project name：bbsDesign
 * Class name：ArticleService
 * description：TODO
 * date：2020/2/20 12:29
 *
 * @author ：XC
 */
public interface ArticleService {
    R save(Article article);
    R delete(int id);
    R findById(int id);
    R findByUid(String uid);
    R selectFollow(String uid);
    R selectAll();
    R getArticleByPage(int page, int pageSize);
    R fuzzySearch(String title, String content);
    R selectTop();
    R findByType(int typeId);
    R imgList(String uid);
    R likedArticle(String uid);
    R setTop(int aid);
}
