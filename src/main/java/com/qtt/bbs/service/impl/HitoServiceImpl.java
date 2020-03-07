package com.qtt.bbs.service.impl;

import com.alibaba.fastjson.JSON;
import com.qtt.bbs.common.util.HttpUtil;
import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.config.SystemConfig;
import com.qtt.bbs.dao.ribon.HitoDao;
import com.qtt.bbs.model.dto.robin.HitoDto;
import com.qtt.bbs.model.entity.Hito;
import com.qtt.bbs.service.HitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project name：bbsDesign
 * Class name：HitoServiceImpl
 * description：TODO
 * date：2020/2/19 14:51
 *
 * @author ：XC
 */
@Service
public class HitoServiceImpl implements HitoService {

    @Autowired
    private HitoDao hitoDao;

    @Override
    public R random() {
        String json = HttpUtil.getJson(SystemConfig.HITO_URL);
        if (null != json) {
            HitoDto dto = JSON.parseObject(json, HitoDto.class);
            Hito hito = new Hito();
            hito.setHitokoto(dto.getHitokoto());
            hito.setFro(dto.getFrom());
            hito.setTyp(dto.getType());
            hito.setCreator(dto.getCreator());
            hitoDao.save(hito);
            return R.ok(hito);
        } else {
            return R.fail("获取数据失败！！");
        }
    }
}
