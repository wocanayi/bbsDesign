package com.qtt.bbs.common.vo;

import lombok.Data;

/**
 * Project name：bbsDesign
 * Class name：R
 * description：TODO
 * date：2020/2/18 22:49
 *
 * @author ：XC
 */
@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    public R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R() {
    }
    public static R ok(){
        return new R(0,"OK",null);
    }
    public static R fail(){
        return new R(1,"ERROR",null);
    }
    public static R ok(Object obj){
        return new R(0,"OK",obj);
    }
    public static R fail(Object obj){
        return new R(1,"ERROR",obj);
    }
    public static R fail(String msg){
        return new R(1,msg,null);
    }
}
