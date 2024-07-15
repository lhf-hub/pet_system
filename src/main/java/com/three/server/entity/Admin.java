package com.three.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin{
    Integer id;
    String name;
    String sex;
    String phone;
    String avatar;
    Integer isDeleted;
    String identity;
    Integer userId;
}
