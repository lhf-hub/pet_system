package com.three.server.service.impl;

import com.three.server.DTO.SellerFilterDTO;
import com.three.server.entity.Seller;
import com.three.server.entity.Subscription;
import com.three.server.mapper.CityMapper;
import com.three.server.mapper.SellerMapper;
import com.three.server.mapper.SubscriptionMapper;
import com.three.server.service.SellerService;
import com.three.server.common.uploadAndGenerateUrl.AliyunOssService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService{
    private final SellerMapper sellerMapper;
    private final SubscriptionMapper subscriptionMapper;
    private final CityMapper cityMapper;
    private final AliyunOssService aliyunOssService;

    @Override
    public List<Seller> findAll() {
        return sellerMapper.findAll();
    }

    @Override
    public int addSeller(Seller seller) {
        return sellerMapper.addSeller(seller);
    }

    @Override
    public int updateSeller(Seller seller) {
        return sellerMapper.updateSeller(seller);
    }

    @Override
    public int deleteSellerById(Integer id) {
        return sellerMapper.deleteSellerById(id);
    }

    @Override
    public List<Seller> filterSeller(SellerFilterDTO sellerFilterDTO) {
        return sellerMapper.filterSeller(sellerFilterDTO);
    }

    @Override
    public String uploadSellerAvatar(MultipartFile avatar, Integer id) {
        if (avatar == null || id == null) {
            throw new IllegalArgumentException("头像和Id必须不为空");
        }
        try {
            String theUrl = aliyunOssService.uploadToFile(avatar,"seller/avatar");
            Map<String, Object> params = new HashMap<>();
            params.put("theUrl", theUrl);
            params.put("id", id);
            int res = sellerMapper.saveSellerAvatarUrl(params);
            if (res >= 1) {
                return theUrl;
            }
        } catch (Exception e) {
            // 简单的异常处理，可以改成其他处理方式，比如打印错误信息
            e.printStackTrace();
            throw new RuntimeException("Error uploading customer avatar", e);
        }
        return null;
    }

    @Override
    public String uploadSellerAttachment(MultipartFile attachment, Integer id) {
        if (attachment == null || id == null) {
            throw new IllegalArgumentException("头像和Id必须不为空");
        }
        try {
            String theUrl = aliyunOssService.uploadToFile(attachment,"seller/attachment");
            Map<String, Object> params = new HashMap<>();
            params.put("theUrl", theUrl);
            params.put("id", id);
            int res = sellerMapper.saveSellerAttachment(params);
            if (res >= 1) {
                return theUrl;
            }
        } catch (Exception e) {
            // 简单的异常处理，可以改成其他处理方式，比如打印错误信息
            e.printStackTrace();
            throw new RuntimeException("Error uploading customer avatar", e);
        }
        return null;    }

    @Override
    public Seller findByUsername(String username) {
        return sellerMapper.findByUsername(username);
    }

    @Override
    public Seller findById(Integer id) {
        return sellerMapper.findById(id);
    }

    @Override
    public String getAvatarUrl(Integer id) {
        return sellerMapper.getAvatarUrl(id);
    }

    @Override
    public String getAttachmentUrl(Integer id) {
        return sellerMapper.getAttachmentUrl(id);
    }

    @Override
    public int sellerSubscriptionPlus(Integer id) {
        return sellerMapper.sellerSubscriptionPlus(id);
    }

    @Override
    @Transactional
    public Boolean addSubscription(int customerId, int sellerId) {
        try {
            // 插入新的订阅记录
            sellerMapper.insertSubscription(new Subscription(customerId, sellerId));

            // 更新卖家的订阅量
            int rowsAffected = sellerMapper.sellerSubscriptionPlus(sellerId);

            if (rowsAffected > 0) {
                return true;
            } else {
                System.err.println("没有找到对应的商户: " + sellerId);
                return false;
            }
        } catch (Exception e) {
            System.err.println("addSubscription 错误: " + e.getMessage());
            throw e; // 抛出异常以触发事务回滚
        }
    }

    @Override
    public Boolean isSubscriptionExit(int customerId, int sellerId) {
        return subscriptionMapper.isExist(customerId,sellerId);
    }
}
