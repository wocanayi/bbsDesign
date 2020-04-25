package com.qtt.bbs.service;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Notify;

/**
 * Project name：bbsDesign
 * Class name：NotifyService
 * description：TODO
 * date：2020/4/22 15:40
 *
 * @author ：XC
 */
public interface NotifyService {
    R addNotifyMessage(Notify notify);

    R findNotifyMessageByUid(String uid);

    R setIsRead(int nid);

    R delMessage(int nid);
}
