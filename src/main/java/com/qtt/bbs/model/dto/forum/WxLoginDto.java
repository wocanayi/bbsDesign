package com.qtt.bbs.model.dto.forum;

import lombok.Data;

/**
 * Project name：bbsDesign
 * Class name：WxLoginDto
 * description：TODO
 * date：2020/2/21 21:43
 *
 * @author ：XC
 */
@Data
public class WxLoginDto {
    /**
     *  属性	类型	说明
     *  openid	string	用户唯一标识
     *  session_key	string	会话密钥
     *  unionid	string	用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
     *  errcode	number	错误码
     *  errmsg
     */
    private String openid;
    private String session_key;
    private String unionid;
    private int errcode;// 0 成功
    private String errmsg;
}
