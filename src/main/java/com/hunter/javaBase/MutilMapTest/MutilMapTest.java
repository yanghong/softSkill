package com.hunter.javaBase.MutilMapTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.collections.MapUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: [{
 *  *   "period": 1,
 *  *   "withdrawTimes": 1,
 *  *   "duringTime": 1,
 *  *   "sellerUid": 1,
 *  *   "withdrawRates": {
 *  *   0:{
 *  *   15:[0.3,0.4,0.3],
 *  *   0:[0.1,0.2,0.7]}
 *  *   }
 *  * }]
 * @author: hunter.yang
 * @date: 20201223 17:18
 */
public class MutilMapTest {

    public static void main(String[] args) {

        String str = "[\n" +
                "    {\n" +
                "        \"period\": 15,\n" +
                "        \"withdrawTimes\": 2,\n" +
                "        \"everyWithdrawTimeMap\": {\n" +
                "            \"1\": 15,\n" +
                "            \"2\": 15\n" +
                "        },\n" +
                "        \"sellerUid\": 125238901,\n" +
                "        \"withdrawRates\": {\n" +
                "            \"0\": {\n" +
                "\t\t\t\"15\": [\n" +
                "                    0,\n" +
                "                    1\n" +
                "                ],\n" +
                "\t\t\t\t\n" +
                "                \"0\": [\n" +
                "                    0.8,\n" +
                "                    0.2\n" +
                "                ]\n" +
                "                \n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";

        List<KaSellerModel> kaSellerWithdrawRates = JSON.parseObject(str, new TypeReference<List<KaSellerModel>>(){});

//        System.out.println(kaSellerWithdrawRates);

        System.out.println(findMatchSplitRule(kaSellerWithdrawRates.get(0).getWithdrawRates(), 16.0));

        System.out.println(JSON.toJSONString(inKaSellerConf(125238901L)));

//        System.out.println(System.currentTimeMillis() / 1000L + 8 * 24 * 3600);

    }

    private static KaSellerModel inKaSellerConf(Long sellerUid) {

        String conf = "[{\n" +
                "    \"period\": 1,\n" +
                "    \"withdrawTimes\": 1,\n" +
                "    \"duringTime\": 1,\n" +
                "    \"sellerUid\": 1,\n" +
                "    \"withdrawRates\": {\n" +
                "    0:{\n" +
                "    15:[0.3,0.4,0.3],\n" +
                "    0:[0.1,0.2,0.7]}\n" +
                "    }\n" +
                "  }]";

        if (StringUtils.isEmpty(conf)) {
            return null;
        }

        try {
            List<KaSellerModel> kaSellerModels = JSON.parseObject(conf, new TypeReference<List<KaSellerModel>>(){});

            if (CollectionUtils.isEmpty(kaSellerModels)) {
                return null;
            }

            Map<Long, KaSellerModel> kaSellerMap = kaSellerModels.stream().collect(Collectors.toMap(KaSellerModel::getSellerUid, p->p, (oldValue, newValue) -> oldValue));

            if (MapUtils.isNotEmpty(kaSellerMap) && kaSellerMap.keySet().contains(sellerUid)) {
                return kaSellerMap.get(sellerUid);
            }
        } catch (Exception e) {
            System.out.println("获取KA商家个性化配置失败：" + e.toString() );
        }

        return null;
    }


    private static Map<Integer, List<Double>> findMatchSplitRule(Map<Integer, Map<Double, List<Double>>> splitRule, Double refundRate) {
        Map<Integer, List<Double>> rule = new HashMap<>();
        for (Integer bizType : splitRule.keySet()) {
            for (Double rate : splitRule.get(bizType).keySet()) {
                if (rate <= refundRate) {
                    rule.put(bizType, splitRule.get(bizType).get(rate));
                    break;
                }
            }
        }
        return rule;
    }
}
