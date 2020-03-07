package com.qtt.bbs.dao.forum;

import com.github.pagehelper.Page;
import com.qtt.bbs.model.dto.forum.ArticleDto;
import com.qtt.bbs.model.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：ArticleDao
 * description：TODO
 * date：2020/2/20 12:23
 *
 * @author ：XC
 */
@Repository
public interface ArticleDao {
    int save(Article article);
    int delete(int id);
    Article findById(int id);
    List<ArticleDto> findByUid(String uid);
    List<ArticleDto> selectAll();
    boolean addReadNum(int id);

    /**
     * 带分页的
     * @return
     */
    Page<ArticleDto> getArticles();

    /**
     * 根据标题或内容进行模糊查询
     * @param title
     * @param content
     * @return
     */
    List<ArticleDto> fuzzySearch(String title, String content);
}