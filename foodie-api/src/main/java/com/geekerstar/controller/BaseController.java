package com.geekerstar.controller;

import org.springframework.stereotype.Controller;

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

}
