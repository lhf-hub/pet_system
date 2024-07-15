package com.three.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Profile{
    Integer id;
    String identity;
    String credit;
    Integer userId;
}
