package com.qtt.bbs.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Project name：bbsDesign
 * Class name：Comment
 * description：TODO
 * date：2020/2/18 22:41
 *
 * @author ：XC
 */
@Data
public class Comment {
    private Integer id;
    private Integer articleId;
    private String uid;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ctime;
    private String authorId;
    private Integer fatherId;
}
