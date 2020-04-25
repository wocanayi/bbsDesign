package com.qtt.bbs.service.impl;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.dao.forum.NotifyDao;
import com.qtt.bbs.model.dto.forum.NotifyDto;
import com.qtt.bbs.model.entity.Notify;
import com.qtt.bbs.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：NotifyServiceImpl
 * description：TODO
 * date：2020/4/22 15:40
 *
 * @author ：XC
 */
@Service
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private NotifyDao notifyDao;

    @Override
    public R addNotifyMessage(Notify notify) {
        int i = notifyDao.addNotifyMessage(notify);
        if (i > 0) {
            return R.ok("success");
        } else {
            return R.fail("fail");
        }
    }

    @Override
    public R findNotifyMessageByUid(String uid) {
        List<NotifyDto> unReadMessages =  notifyDao.findNotifyMessageByUid(uid);
        if (unReadMessages != null) {
            return R.ok(unReadMessages);
        } else {
            return R.fail("暂无消息。");
        }
    }

    @Override
    public R setIsRead(int nid) {
        int i = notifyDao.setIsRead(nid);
        if (i > 0) {
            return R.ok("success");
        } else {
            return R.fail("fail");
        }
    }

    @Override
    public R delMessage(int nid) {
        int i = notifyDao.delMessage(nid);
        if (i > 0) {
            return R.ok("success");
        } else {
            return R.fail("fail");
        }
    }
}
