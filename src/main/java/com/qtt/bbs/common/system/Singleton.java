package com.qtt.bbs.common.system;

/**
 * Project name：bbsDesign
 * Class name：Singleton
 * description：TODO
 * date：2020/3/12 18:40
 *
 * @author ：XC
 */
// 单例
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        // 测试单例
        System.out.println(Singleton.getInstance());
    }

}
