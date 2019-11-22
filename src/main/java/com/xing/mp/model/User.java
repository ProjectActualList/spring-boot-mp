package com.xing.mp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;

    private String nickName;

    private String realName;

    private String phone;

    private String avatarUrl;

    private String gender;

    private String openid;

    private String unionid;

    private String country;

    private String province;

    private String city;

}
