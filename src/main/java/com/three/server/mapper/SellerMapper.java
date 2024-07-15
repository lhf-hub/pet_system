package com.three.server.mapper;

import com.three.server.DTO.SellerFilterDTO;
import com.three.server.entity.Seller;
import com.three.server.entity.Subscription;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SellerMapper {
    List<Seller> findAll();
    int addSeller(Seller seller);
    int updateSeller(Seller seller);
    int deleteSellerById(Integer id);
    List<Seller> filterSeller(SellerFilterDTO sellerFilterDTO);
    int saveSellerAvatarUrl(String theUrl,Integer id);
    int saveSellerAvatarUrl(Map<String, Object> params);
    int saveSellerAttachment(Map<String, Object> params);
    Seller findByUsername(String username);
    Seller findById(Integer id);
    String getAvatarUrl(Integer id);
    String getAttachmentUrl(Integer id);
    int sellerSubscriptionPlus(Integer id);
    int insertSubscription(Subscription subscription);
}
