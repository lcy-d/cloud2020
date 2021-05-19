package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id; //id
    private Long productId; //产品id
    private Integer total;//产品总数
    private Integer used;//已卖数量
    private Integer residue;//剩余数量
}
