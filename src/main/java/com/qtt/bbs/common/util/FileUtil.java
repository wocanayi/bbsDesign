package com.qtt.bbs.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Project name：bbsDesign
 * Class name：FileUtils
 * description：TODO
 * date：2020/2/27 14:00
 *
 * @author ：XC
 */
public class FileUtil {

    /**
     *
     * @param files
     * @param path
     * @param fileName
     * @return
     */
    public static boolean upload(MultipartFile files, String path, String fileName) {
        // 生成新的文件名
        String realPath = path + "/" + FileNameUtil.getFileName(fileName);

        File dest = new File(realPath);

        // 判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            // 保存文件
            files.transferTo(dest);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
