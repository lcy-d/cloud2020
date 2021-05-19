package com.atguigu.springcloud.alibaba.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id; //订单id
    private Long userId; //用户id
    private Long productId; //产品id
    private Integer count; //数量
    private BigDecimal money; //金额
    private Integer status; //订单状态：0：创建中；1：已完结

}
