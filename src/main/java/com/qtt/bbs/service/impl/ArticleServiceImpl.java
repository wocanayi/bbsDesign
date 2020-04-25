package com.qtt.bbs.service.impl;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.dao.forum.ArticleDao;
import com.qtt.bbs.model.dto.en.ImgList;
import com.qtt.bbs.model.dto.forum.ArticleDto;
import com.qtt.bbs.model.entity.Article;
import com.qtt.bbs.model.entity.PageBean;
import com.qtt.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public R save(Article article) {
        int save = articleDao.save(article);
        if (save > 0) {
            return R.ok("成功！");
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
        ArticleDto article = articleDao.findById(id);
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
    public R selectFollow(String uid) {
        List<ArticleDto> articleDtos = articleDao.selectFollow(uid);
        if (null == articleDtos) {
            return R.fail("无关注人帖子。");
        } else {
            return R.ok(articleDtos);
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
        PageBean<ArticleDto> lists = new PageBean<>();
        long total = articleDao.articleNum();
        lists.setCurrentPage(page);
        lists.setTotalPage((int) Math.ceil((double) total / pageSize));
        lists.setTotalNum(total);
        /*分页查询limit后的两个参数含义： 起始下标(（page-1）*size), 每页的条数*/
        lists.setLists(articleDao.getArticles((page-1)*pageSize, pageSize));
        return R.ok(lists);
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

    @Override
    public R selectTop() {
        List<ArticleDto> articleDtos = articleDao.selectTop();
        if (null != articleDtos) {
            return R.ok(articleDtos);
        } else {
            return R.fail("无数据。");
        }
    }

    @Override
    public R findByType(int typeId) {
        List<ArticleDto> articleDtos = articleDao.findByType(typeId);
        if (null != articleDtos) {
            return R.ok(articleDtos);
        } else {
            return R.fail("暂无数据。");
        }
    }

    @Override
    public R imgList(String uid) {
        List<ImgList> imgLists = articleDao.imgList(uid);
        if (null != imgLists) {
            return R.ok(imgLists);
        } else {
            return R.fail("无信息。");
        }
    }

    @Override
    public R likedArticle(String uid) {
        List<ArticleDto> articleDtos = articleDao.likedArticle(uid);
        if (articleDtos != null) {
            return R.ok(articleDtos);
        } else {
            return R.fail("暂无点赞哟。");
        }
    }

    @Override
    public R setTop(int aid) {
        int i = articleDao.setTop(aid);
        if (i > 0) {
            return R.ok("设置成功");
        } else {
            return R.fail("设置失败");
        }
    }
}
