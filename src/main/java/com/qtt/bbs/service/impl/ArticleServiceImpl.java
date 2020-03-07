package com.qtt.bbs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.dao.forum.ArticleDao;
import com.qtt.bbs.model.dto.forum.ArticleDto;
import com.qtt.bbs.model.entity.Article;
import com.qtt.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：ArticleServiceImpl
 * description：TODO
 * date：2020/2/20 12:30
 *
 * @author ：XC
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public R save(ArticleDto articleDto) {
        Article article = new Article();
        article.setTypeId(articleDto.getTypeId());
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        article.setCtime(new Date());
        article.setOrigin(articleDto.getOrigin());
        article.setUid(articleDto.getUid());

        if (articleDao.save(article) > 0) {
            return R.ok(article);
        } else {
            return R.fail("发帖失败!");
        }
    }

    @Override
    public R delete(int id) {
        if (articleDao.delete(id) > 0) {
            return R.ok("删除成功!");
        } else {
            return R.fail("删除失败!");
        }
    }

    @Override
    public R findById(int id) {
        Article article = articleDao.findById(id);
        if (null != article) {
            // 添加帖子浏览量
            articleDao.addReadNum(id);

            return R.ok(article);
        } else {
            return R.fail("无该条信息!");
        }
    }

    @Override
    public R findByUid(String uid) {
        List<ArticleDto> articles = articleDao.findByUid(uid);
        if (null != articles) {
            return R.ok(articles);
        } else {
            return R.fail("无信息!");
        }
    }

    @Override
    public R selectAll() {
        List<ArticleDto> articles = articleDao.selectAll();
        if (null == articles) {
            return R.fail("暂无信息！");
        } else {
            return R.ok(articles);
        }
    }

    @Override
    public R getArticleByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        Page<ArticleDto> articles = articleDao.getArticles();
        return R.ok(articles);
    }

    @Override
    public R fuzzySearch(String title, String content) {
        List<ArticleDto> articleDtos = articleDao.fuzzySearch(title, content);
        if (null != articleDtos) {
            return R.ok(articleDtos);
        } else {
            return R.fail("暂未查到你所要的数据。");
        }
    }
}
