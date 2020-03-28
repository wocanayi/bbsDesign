package com.qtt.bbs.service.impl;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.dao.forum.ArticleTypeDao;
import com.qtt.bbs.model.entity.ArticleType;
import com.qtt.bbs.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：ArticleTypeServiceImpl
 * description：TODO
 * date：2020/2/20 20:24
 *
 * @author ：XC
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeDao typeDao;

    @Override
    public R save(ArticleType articleType) {
        if (typeDao.save(articleType) > 0) {
            return R.ok("成功");
        } else {
            return R.fail("fail!");
        }
    }

    @Override
    public R delete(int id) {
        if (typeDao.delete(id) > 0) {
            return R.ok("删除成功!");
        } else {
            return R.fail("删除失败!");
        }
    }

    @Override
    public R selectAll() {
        List<ArticleType> articleTypes = typeDao.selectAll();
        if (null == articleTypes) {
            return R.fail("暂无！");
        } else {
            return R.ok(articleTypes);
        }
    }

    @Override
    public R selectTypeNums(int typeId) {
        Long aLong = typeDao.typeNums(typeId);
        if (aLong == null) {
            return R.fail("暂无发帖！");
        } else {
            return R.ok(aLong);
        }
    }

    @Override
    public R findByTypeId(int id) {
        ArticleType byTypeId = typeDao.findByTypeId(id);
        if (byTypeId != null) {
            return R.ok(byTypeId);
        } else {
            return R.fail();
        }
    }
}
