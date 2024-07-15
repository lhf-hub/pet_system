package com.three.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail {
    Integer id;
    Integer goodId;
    Integer quantity;
    Integer orderId;
    Integer isDeleted;
    Integer state;
    Double total;
}
