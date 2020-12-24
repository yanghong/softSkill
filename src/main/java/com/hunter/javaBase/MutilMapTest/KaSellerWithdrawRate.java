package com.hunter.javaBase.MutilMapTest;

import lombok.Data;

/**
 * @description: KA 商家个批次回款比例
 * @author: hunter.yang
 * @date: 20201223 15:34
 */
@Data
public class KaSellerWithdrawRate {

    /**
     * 批次号
     */
    private Integer batchNumber;

    /**
     * 批次比例
     */
    private Double batchRate;

}
