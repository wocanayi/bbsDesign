package com.qtt.bbs.common.util;

import java.util.UUID;

/**
 * Project name：bbsDesign
 * Class name：UUIDUtil
 * description：TODO
 * date：2020/2/27 14:27
 *
 * @author ：XC
 */
public class UUIDUtil {
    /**
     * 生成文件名
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
