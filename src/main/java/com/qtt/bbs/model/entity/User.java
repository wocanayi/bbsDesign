package com.qtt.bbs.model.entity;

import com.qtt.bbs.model.dto.en.Gender;
import lombok.Data;

/**
 * Project name：bbsDesign
 * Class name：Master
 * description：TODO
 * date：2020/2/18 22:47
 *
 * @author ：XC
 */
@Data
public class User {
    private Integer id;
    private String uid;
    private String nickName;
    private Integer gender;
    private String city;
    private String avatarUrl;
    private String unionId;
    private Integer balance;

}
