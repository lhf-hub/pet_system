package com.three.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    String name;
    String sex;
    String phone;
    String avatar;
    String address;
    Integer isDeleted;
}
