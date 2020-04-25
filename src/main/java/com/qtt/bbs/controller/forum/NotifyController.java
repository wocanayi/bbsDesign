package com.qtt.bbs.controller.forum;

import com.qtt.bbs.common.vo.R;
import com.qtt.bbs.model.entity.Notify;
import com.qtt.bbs.service.NotifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Project name：bbsDesign
 * Class name：NotifyController
 * description：TODO
 * date：2020/4/22 15:39
 *
 * @author ：XC
 */
@Api(value = "消息通知相关操作", tags = "消息通知相关操作")
@RestController
@CrossOrigin
public class NotifyController {

    @Autowired
    private NotifyService notifyService;

    @ApiOperation(value = "添加通知消息", notes = "添加通知消息")
    @PostMapping("/notify/addNotifyMessage.do")
    public R addNotifyMessage(@RequestParam int aid, @RequestParam int action, @RequestParam String senderId,
                              @RequestParam int senderType, @RequestParam String uid, @RequestParam int cid) {
        Notify notify = new Notify();
        notify.setAid(aid);
        notify.setAction(action);
        notify.setSenderId(senderId);
        notify.setSenderType(senderType);
        notify.setUid(uid);
        notify.setCid(cid);
        return notifyService.addNotifyMessage(notify);
    }

    @ApiOperation(value = "所有通知消息", notes = "所有通知消息")
    @GetMapping("/notify/findNotifyMessageByUid.do")
    public R findNotifyMessageByUid(@RequestParam String uid) {
        return notifyService.findNotifyMessageByUid(uid);
    }

    @ApiOperation(value = "设置通知消息已读", notes = "设置通知消息已读")
    @PutMapping("/notify/setIsRead.do")
    public R setIsRead(@RequestParam int nid) {
        return notifyService.setIsRead(nid);
    }

    @ApiOperation(value = "删除通知消息", notes = "删除通知消息")
    @DeleteMapping("/notify/delMessage.do")
    public R delMessage(@RequestParam int nid) {
        return notifyService.delMessage(nid);
    }
}
