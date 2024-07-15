package com.three.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    Integer id;
    String name;
    String owner;
    String phone;
    Integer cityId; //城市Id
    String ownerIdentity;
    String avatar;
    String address;
    Integer userId;
    Long subscription;
    String description;
    Integer state;
    Integer isDeleted;
    Long flow;
    Timestamp createdAt;
    String attachment;  //营业执照
}
