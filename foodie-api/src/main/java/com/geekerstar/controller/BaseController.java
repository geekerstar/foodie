package com.geekerstar.controller;

import org.springframework.stereotype.Controller;

import java.io.File;

/**
 * @author geekerstar
 * date: 2019/11/20 20:53
 * description:
 */
@Controller
public class BaseController {
    public static final Integer COMMON_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 20;

    public static final String FOODIE_SHOPCART = "shopcart";

    // 支付中心的调用地址
    String paymentUrl = "http://xxx/foodie-payment/payment/createMerchantOrder";		// produce

    // 微信支付成功 -> 支付中心 -> 天天吃货平台
    //                       |-> 回调通知的url
    String payReturnUrl = "http://xxx/foodie-dev-api/orders/notifyMerchantOrderPaid";

    // 用户上传头像的位置
    public static final String IMAGE_USER_FACE_LOCATION = File.separator + "workspaces" +
            File.separator + "images" +
            File.separator + "foodie" +
            File.separator + "faces";
//    public static final String IMAGE_USER_FACE_LOCATION = "/workspaces/images/foodie/faces";

}
