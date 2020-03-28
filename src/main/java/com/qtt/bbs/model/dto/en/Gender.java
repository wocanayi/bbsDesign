package com.qtt.bbs.model.dto.en;

/**
 * Project name：bbsDesign
 * Class name：Gender
 * description：TODO
 * date：2020/3/12 11:19
 *
 * @author ：XC
 */
public enum Gender {
    未知(0, "未知"),
    男(1, "男"),
    女(2, "女");

    private Byte value;
    private String name;

    Gender(int value, String name) {
        this.value = (byte)value;
        this.name = name;
    }

    public Byte getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
