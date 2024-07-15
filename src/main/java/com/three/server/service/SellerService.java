package com.three.server.service;

import com.three.server.DTO.SellerFilterDTO;
import com.three.server.entity.Seller;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SellerService {
    List<Seller> findAll();
    int addSeller(Seller seller);
    int updateSeller(Seller seller);
    int deleteSellerById(Integer id);
    List<Seller> filterSeller(SellerFilterDTO sellerFilterDTO);
    String uploadSellerAvatar(MultipartFile avatar, Integer id);
    String uploadSellerAttachment(MultipartFile avatar,Integer id);
    Seller findByUsername(String username);
    Seller findById(Integer id);
    String getAvatarUrl(Integer id);
    String getAttachmentUrl(Integer id);
    int sellerSubscriptionPlus(Integer id);
    Boolean addSubscription(int customerId ,int sellerId);
    Boolean isSubscriptionExit(int customerId ,int sellerId);
}
