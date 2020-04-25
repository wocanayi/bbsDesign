package com.qtt.bbs.dao.forum;

import com.qtt.bbs.model.dto.forum.NotifyDto;
import com.qtt.bbs.model.entity.Notify;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：NotifyDao
 * description：TODO
 * date：2020/4/22 15:40
 *
 * @author ：XC
 */
@Repository
public interface NotifyDao {
    int addNotifyMessage(Notify notify);

    List<NotifyDto> findNotifyMessageByUid(String uid);

    int setIsRead(int nid);

    int delMessage(int nid);
}
