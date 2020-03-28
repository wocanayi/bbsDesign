package com.qtt.bbs.common.system;

/**
 * Project name：bbsDesign
 * Class name：AppContext
 * description：TODO
 * date：2020/3/12 10:17
 *
 * @author ：XC
 */
public class AppContext {
    private static String CURRENT_WECHAT_OPENID = null;

    public static void setAppContext(String uid) {
        CURRENT_WECHAT_OPENID = uid;
    }

    public static String getAppContext() {
        return CURRENT_WECHAT_OPENID;
    }
}
