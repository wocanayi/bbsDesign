package com.qtt.bbs.model.dto.forum;

import com.qtt.bbs.model.dto.en.Gender;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * Project name：bbsDesign
 * Class name：UserDto
 * description：TODO
 * date：2020/3/10 21:35
 *
 * @author ：XC
 */
@Data
public class UserDto {
    private String avatarUrl;
    private String city;
    private String country;
    private Integer gender;
    private String language;
    private String nickName;
    private String province;
}
