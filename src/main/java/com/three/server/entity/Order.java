package com.three.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    Integer id;
    Integer customerId;
    Timestamp time;
    Double total;
    Integer isDeleted;
}
