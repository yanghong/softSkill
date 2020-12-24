package com.hunter.javaBase.MutilMapTest;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description: [{
 *   "period": 1,
 *   "withdrawTimes": 1,
 *   "duringTime": 1,
 *   "sellerUid": 1,
 *   "withdrawRates": {
 *   0:{
 *   15:[0.3,0.4,0.3],
 *   0:[0.1,0.2,0.7]}
 *   }
 * }]
 * @author: hunter.yang
 * @date: 20201223 15:31
 */
@Data
public class KaSellerModel {

    /**
     * 账期时间
     */
    private Long period;

    /**
     * 回款批次
     */
    private Integer withdrawTimes;

    /**
     * 回款批次间隔时间
     */
    private Integer duringTime;

    /**
     * 各批次回款比例
     */
    private Map<Integer, Map<Double, List<Double>>> withdrawRates;

    /**
     * 商家uid
     */
    private Long sellerUid;
}
