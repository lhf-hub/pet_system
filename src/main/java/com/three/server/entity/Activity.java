package com.three.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    Integer id;
    String name;
    Integer goodId;
    Timestamp startTime;
    Timestamp endTime;
    String description;
    String avatar;
    Double discount;
    Integer isDeleted;
    Timestamp createdAt;
}
