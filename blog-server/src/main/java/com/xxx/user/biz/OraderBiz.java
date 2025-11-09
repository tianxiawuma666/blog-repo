package com.xxx.user.biz;

import com.xxx.base.utils.R;

public class OraderBiz {
    public R<String> createOrder(Long userId, Long productId) {
        return R.ok("创建订单成功");
    }
}
