package com.three.server.DTO;

import com.three.server.entity.Detail;
import com.three.server.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailsDTO {
    private Order order;
    private List<Detail> details;
}

