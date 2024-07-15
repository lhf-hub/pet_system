package com.three.server.DTO;

import lombok.Data;

@Data
public class SellerFilterDTO {
    String name;
    String owner;
    String phone;
    Integer city;
    Integer lowest;
    Integer highest;
}
