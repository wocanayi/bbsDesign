package com.qtt.bbs.common.util;

import java.util.UUID;

/**
 * Project name：bbsDesign
 * Class name：FileNameUtil
 * description：TODO
 * date：2020/2/27 14:11
 *
 * @author ：XC
 */
public class FileNameUtil {
    /**
     * 获取文件后缀
     * @param fileName fileName
     * @return
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     * @param fileOriginName 原文件名
     * @return
     */
    public static String getFileName(String fileOriginName) {
        return UUIDUtil.getUUID() + FileNameUtil.getSuffix(fileOriginName);
    }
}
