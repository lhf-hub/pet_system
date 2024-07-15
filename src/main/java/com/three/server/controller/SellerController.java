package com.three.server.controller;

import com.auth0.jwt.JWT;
import com.three.server.DTO.SellerFilterDTO;
import com.three.server.common.responseBodyCustom.ApiResponse;
import com.three.server.entity.Customer;
import com.three.server.entity.Seller;
import com.three.server.service.impl.SellerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerServiceImpl sellerService;

    // 增加商户
    @PostMapping("/add")
    public ApiResponse<Void> add(@RequestBody Seller seller) {
        int effNum = sellerService.addSeller(seller);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "商户增加失败");
    }

    // 更新商户信息
    @PostMapping("/update")
    public ApiResponse<Void> update(@RequestBody Seller seller) {
        int effNum = sellerService.updateSeller(seller);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "商户增加失败");
    }

    // 删除商户
    @GetMapping("/delete/{id}")
    public ApiResponse<Void> delete(@PathVariable Integer id) {
        int effNum = sellerService.deleteSellerById(id);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "商户删除失败");
    }

    // 查找所有商户
    @GetMapping("/findAll")
    public ApiResponse<List<Seller>> findAll() {
        return ApiResponse.success(sellerService.findAll());
    }

    // 根据用户名查找商户
    @GetMapping("/findByUsername/{username}")
    public ApiResponse<Seller> findByUsername(@PathVariable String username) {
        return sellerService.findByUsername(username) == null ?
                ApiResponse.fail(501,"没有该用户名对应的商户") : ApiResponse.success(sellerService.findByUsername(username));
    }

    // 根据Id查找商户
    @GetMapping("/findById/{id}")
    public ApiResponse<Seller> findById(@PathVariable Integer id) {
        return sellerService.findById(id) == null ?
                ApiResponse.fail(501,"没有该id对应的商户") : ApiResponse.success(sellerService.findById(id));
    }

    // 多条件查询客户信息接口
    @PostMapping("/filter")
    public ApiResponse<List<Seller>> filter(@RequestBody SellerFilterDTO sellerFilterDTO) {
        return ApiResponse.success(sellerService.filterSeller(sellerFilterDTO));
    }

//     上传商户头像
    @PostMapping("/uploadAvatar")
    public ApiResponse<String> uploadAvatar(@RequestBody MultipartFile avatar,HttpServletRequest request){
        if (request.getHeader("token").isEmpty()) return ApiResponse.fail(501,"身份验证失败");
        String id = String.valueOf(JWT.decode(request.getHeader("token")).getClaim("id"));
        System.out.println("controller:"+id);
        String res = sellerService.uploadSellerAvatar(avatar, Integer.valueOf(id.replaceAll("\"", "")));
        return res != null ? ApiResponse.success(res) : ApiResponse.fail(501,"头像保存失败");
    }

    //获取商户头像的Url
    @GetMapping("/getAvatarUrl/{id}")
    public ApiResponse<String> getAvatarUrl(@PathVariable Integer id){
        if (id == null) return ApiResponse.fail(501,"商户id不能为空");
        if (sellerService.getAvatarUrl(id) == null) return ApiResponse.fail(501,"商户头像为空");
        return ApiResponse.success(sellerService.getAvatarUrl(id));
    }

    //上传商户营业执照
    @PostMapping("/uploadAttachment")
    public ApiResponse<String> uploadAttachment(@RequestBody MultipartFile attachment,HttpServletRequest request){
        if (request.getHeader("token").isEmpty()) return ApiResponse.fail(501,"身份验证失败");
        String id = String.valueOf(JWT.decode(request.getHeader("token")).getClaim("id"));
        System.out.println("controller:"+id);
        String res = sellerService.uploadSellerAttachment(attachment, Integer.valueOf(id.replaceAll("\"", "")));
        return res != null ? ApiResponse.success(res) : ApiResponse.fail(501,"头像保存失败");
    }

    //获取商户营业执照
    @GetMapping("/getAttachmentUrl/{id}")
    public ApiResponse<String> getAttachmentUrl(@PathVariable Integer id){
        if (id == null) return ApiResponse.fail(501,"商户id不能为空");
        if (sellerService.getAttachmentUrl(id) == null) return ApiResponse.fail(501,"商户营业执照为空");
        return ApiResponse.success(sellerService.getAttachmentUrl(id));
    }

    //新增订阅
    @GetMapping("/subscribe/{customerId}/{sellerId}")
    public ApiResponse<String> subscribe(@PathVariable Integer customerId,@PathVariable Integer sellerId)
    {
        if (sellerService.isSubscriptionExit(customerId,sellerId))
            return ApiResponse.fail(501,"订阅失败，已订阅该商户");
        return sellerService.addSubscription(customerId,sellerId) ? ApiResponse.success("订阅成功")
                : ApiResponse.fail(501,"订阅失败，商户不存在");
    }
}
