package com.education.user.bean.to;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author TuTu
 * @date 2020/6/18 10:45
 */
@Data
public class UserTO {

    private String mobile;

    private String nickname;

    private Integer statusId;

    private LocalDateTime createTime;

    private LocalDateTime endTime;

    private Integer currend;

    private Integer limit;
}
