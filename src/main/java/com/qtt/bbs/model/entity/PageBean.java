package com.qtt.bbs.model.entity;

import lombok.Data;

import java.util.List;

/**
 * Project name：bbsDesign
 * Class name：PageBean
 * description：TODO
 * date：2020/3/28 13:15
 *
 * @author ：XC
 */
@Data
public class PageBean<T> {
    private int currentPage;
    private int totalPage;
    private long totalNum;
    private List<T> lists;
}
