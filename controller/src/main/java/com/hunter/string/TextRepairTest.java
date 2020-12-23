package com.hunter.string;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 文本去重
 * @date 2020/12/15 14:07
 */
public class TextRepairTest {
    
    public static void main(String[] args) {
        String str = "任务：beidian_offline_item_hot_data_redis 上游搜索与推荐组和广告组在线任务：[beidian_item_action_log, beidian_item_action_log, beidian_online_items, beidian_item_show_cart_action_log, beidian_item_show_cart_action_log]\n" +
                "任务：p2i_xgboost_output_redis 上游搜索与推荐组和广告组在线任务：[beidian_online_items, p2p_xgboost_output, beidian_online_items, shell_p2p_predict, p2p_xgboost_predict, shell_p2p_guess_you_like_xgboost_train, p2p_guess_you_like_fg, p2p_guess_you_like_xgboost_train, beidian_p2p_recom_sim, beidian_p2p_recom_title_word2vec_sim_data_ext, p2p_guess_you_like_feature, beidian_p2p_recom_action_sim, beidian_p2p_show_wbcosine_sim, beidian_p2p_cart_wbcosine_sim, beidian_p2p_buy_wbcosine_sim, beidian_p2p_show_buy_wbcosine_sim, p2p_guess_you_like_train, beidian_p2p_show_wbcosine_sim_today, beidian_p2p_show_wbcosine_sim_last_interval, beidian_p2p_show_wbcosine_sim_old_part, beidian_p2p_cart_wbcosine_sim_today, beidian_p2p_cart_wbcosine_sim_last_interval, beidian_p2p_cart_wbcosine_sim_old_part, beidian_p2p_buy_wbcosine_sim_today, beidian_p2p_buy_wbcosine_sim_last_interval, beidian_p2p_buy_wbcosine_sim_old_part, beidian_p2p_show_buy_wbcosine_sim_today, beidian_p2p_show_buy_wbcosine_sim_last_interval, beidian_p2p_show_buy_wbcosine_sim_old_part, i2i_guess_you_like_click, i2i_guess_you_like_show, beidian_item_action_log, beidian_item_show_cart_action_log, beidian_p2p_buy_wbcosine_s\n" +
                "im_old_part, beidian_item_action_log, beidian_p2p_show_buy_wbcosine_sim_today, beidian_p2p_show_buy_wbcosine_sim_last_interval, beidian_p2p_show_buy_wbcosine_sim_old_part, beidian_app_show_click_cart_log, i2i_guess_you_like_click, i2i_guess_you_like_show, beidian_p2p_show_wbcosine_sim, beidian_p2p_cart_wbcosine_sim, beidian_p2p_buy_wbcosine_sim, beidian_p2p_recom_title_word2vec_sim_data_ext, p2p_guess_you_like_train, beidian_item_show_cart_action_log, beidian_app_log_day_hour, beidian_p2p_show_wbcosine_sim_today, beidian_p2p_show_wbcosine_sim_last_interval, beidian_p2p_show_wbcosine_sim_old_part, beidian_p2p_cart_wbcosine_sim_today, beidian_p2p_cart_wbcosine_sim_last_interval, beidian_p2p_cart_wbcosine_sim_old_part, beidian_p2p_buy_wbcosine_sim_today, beidian_p2p_buy_wbcosine_sim_last_interval, beidian_p2p_buy_wbcosine_sim_old_part, beidian_app_log_day_hour]\n" +
                "任务：beidian_offline_buy_user_trigger_redis 上游搜索与推荐组和广告组在线任务：[beidian_offline_buy_user_trigger, beidian_offline_buy_user_trigger, beibei_weixin_beidian_user_item_action_log, beibei_weixin_beidian_device_id_uid_info, beibei_beidian_weixin_ul_id_uid_info, beibei_weixin_beidian_user_item_time_span_action_log_sum, weixin_xiaochengxu_show_click_cart_log, m_zhan_show_click_cart_log, beidian_app_show_click_cart_log, beidian_app_log_day_hour, m_zhan_log_day_hour, weixin_xiaochengxu_log_day_hour, beidian_app_log_day_hour]\n" +
                "任务：hive2redis_beidian_offline_hot_brands 上游搜索与推荐组和广告组在线任务：[beidian_offline_hot_brands, beidian_offline_hot_brands, hive2redis_beidian_brand_i2trend, beidian_item_action_log, beidian_brand_i2trend, beidian_item_show_cart_action_log, beidian_item_show_cart_action_log]\n" +
                "任务：hive2redis_beidian_user_type_and_nearestuid 上游搜索与推荐组和广告组在线任务：[hive_beidian_user_type_and_nearestuid, hive_beidian_user_type_and_nearestuid, beidian_user_type_and_nearestuid, beidian_active_user, beidian_user_action_detail, beibei_weixin_beidian_user_item_time_span_action_log_sum, beibei_weixin_beidian_user_item_action_log, beibei_weixin_beidian_device_id_uid_info, beibei_beidian_weixin_ul_id_uid_info, weixin_xiaochengxu_show_click_cart_log, m_zhan_show_click_cart_log, beidian_app_show_click_cart_log, beidian_app_log_day_hour, m_zhan_log_day_hour, weixin_xiaochengxu_log_day_hour, beidian_app_log_day_hour]\n" +
                "任务：beidian_offline_p2i_data_redis 上游搜索与推荐组和广告组在线任务：[beidian_online_items, beidian_online_items, beidian_p2p_recom_sim, beidian_p2p_recom_action_sim, beidian_p2p_recom_title_word2vec_sim_data_ext, beidian_p2p_show_wbcosine_sim, beidian_p2p_cart_wbcosine_sim, beidian_p2p_buy_wbcosine_sim, beidian_p2p_show_buy_wbcosine_sim, beidian_p2p_show_wbcosine_sim_today, beidian_p2p_show_wbcosine_sim_last_interval, beidian_p2p_show_wbcosine_sim_old_part, beidian_p2p_cart_wbcosine_sim_today, beidian_p2p_cart_wbcosine_sim_last_interval, beidian_p2p_cart_wbcosine_sim_old_part, beidian_p2p_buy_wbcosine_sim_today, beidian_p2p_buy_wbcosine_sim_last_interval, beidian_p2p_buy_wbcosine_sim_old_part, beidian_p2p_show_buy_wbcosine_sim_today, beidian_p2p_show_buy_wbcosine_sim_last_interval, beidian_p2p_show_buy_wbcosine_sim_old_part, beidian_item_action_log, beidian_item_show_cart_action_log, beidian_item_show_cart_action_log]\n" +
                "任务：hive2redis_beidian_cart_user_feature 上游搜索与推荐组和广告组在线任务：[hive_beidian_user_feature, beidian_user_feature, beidian_raw_feature_statistics, beidian_user_static_feature, beidian_user_behavior_feature, item_pur_power_xl, beidian_user_item_decayed_action_data, beidian_item_price_level, beidian_user_static_feature_day, beibei_weixin_beidian_user_item_time_span_action_log_sum, beibei_weixin_beidian_user_item_action_log, beibei_weixin_beidian_device_id_uid_info, beibei_beidian_weixin_ul_id_uid_info, weixin_xiaochengxu_show_click_cart_log, m_zhan_show_click_cart_log, beidian_app_show_click_cart_log, beidian_app_log_day_hour, m_zhan_log_day_hour, weixin_xiaochengxu_log_day_hour, beidian_app_log_day_hour]\n" +
                "任务：hive2redis_beidian_ads_i2a_bts 上游搜索与推荐组和广告组在线任务：[beidian_ads_i2a_bts, beidian_ads_i2a_bts, beidian_ads_item_recall, beidian_online_items, beidian_p2p_recom_sim, beidian_p2p_recom_action_sim, beidian_p2p_recom_title_word2vec_sim_data_ext, beidian_p2p_show_wbcosine_sim, beidian_p2p_cart_wbcosine_sim, beidian_p2p_buy_wbcosine_sim, beidian_p2p_show_buy_wbcosine_sim, beidian_p2p_show_wbcosine_sim_today, beidian_p2p_show_wbcosine_sim_last_interval, beidian_p2p_show_wbcosine_sim_old_part, beidian_p2p_cart_wbcosine_sim_today, beidian_p2p_cart_wbcosine_sim_last_interval, beidian_p2p_cart_wbcosine_sim_old_part, beidian_p2p_buy_wbcosine_sim_today, beidian_p2p_buy_wbcosine_sim_last_interval, beidian_p2p_buy_wbcosine_sim_old_part, beidian_p2p_show_buy_wbcosine_sim_today, beidian_p2p_show_buy_wbcosine_sim_last_interval, beidian_p2p_show_buy_wbcosine_sim_old_part, beidian_item_action_log, beidian_item_show_cart_action_log, beidian_item_show_cart_action_log]\n" +
                "任务：hive2redis_beidian_brand_p2i 上游搜索与推荐组和广告组在线任务：[beidian_brand_p2i, beidian_brand_p2i, hive2redis_beidian_brand_i2trend, beidian_p2p_recom_sim, beidian_brand_i2trend, beidian_online_items, beidian_p2p_recom_action_sim, beidian_p2p_recom_title_word2vec_sim_data_ext, beidian_p2p_show_wbcosine_sim, beidian_p2p_cart_wbcosine_sim, beidian_p2p_buy_wbcosine_sim, beidian_p2p_show_buy_wbcosine_sim, beidian_p2p_show_wbcosine_sim_today, beidian_p2p_show_wbcosine_sim_last_interval, beidian_p2p_show_wbcosine_sim_old_part, beidian_p2p_cart_wbcosine_sim_today, beidian_p2p_cart_wbcosine_sim_last_interval, beidian_p2p_cart_wbcosine_sim_old_part, beidian_p2p_buy_wbcosine_sim_today, beidian_p2p_buy_wbcosine_sim_last_interval, beidian_p2p_buy_wbcosine_sim_old_part, beidian_p2p_show_buy_wbcosine_sim_today, beidian_p2p_show_buy_wbcosine_sim_last_interval, beidian_p2p_show_buy_wbcosine_sim_old_part, beidian_item_action_log, beidian_item_show_cart_action_log, beidian_item_show_cart_action_log]\n" +
                "任务：beidian_p2i_recom_data_redis 上游搜索与推荐组和广告组在线任务：[beidian_online_items, beidian_p2p_recom_sim, beidian_online_items, beidian_p2p_recom_action_sim, beidian_p2p_recom_title_word2vec_sim_data_ext, beidian_p2p_show_wbcosine_sim, beidian_p2p_cart_wbcosine_sim, beidian_p2p_buy_wbcosine_sim, beidian_p2p_show_buy_wbcosine_sim, beidian_p2p_show_wbcosine_sim_today, beidian_p2p_show_wbcosine_sim_last_interval, beidian_p2p_show_wbcosine_sim_old_part, beidian_p2p_cart_wbcosine_sim_today, beidian_p2p_cart_wbcosine_sim_last_interval, beidian_p2p_cart_wbcosine_sim_old_part, beidian_p2p_buy_wbcosine_sim_today, beidian_p2p_buy_wbcosine_sim_last_interval, beidian_p2p_buy_wbcosine_sim_old_part, beidian_p2p_show_buy_wbcosine_sim_today, beidian_p2p_show_buy_wbcosine_sim_last_interval, beidian_p2p_show_buy_wbcosine_sim_old_part, beidian_item_action_log, beidian_item_show_cart_action_log, beidian_item_show_cart_action_log]\n" +
                "任务：beidian_p2i_recom_data_word2vec_redis 上游搜索与推荐组和广告组在线任务：[beidian_online_items, beidian_online_items, beidian_p2p_recom_action_sim, beidian_p2p_show_wbcosine_sim, beidian_p2p_cart_wbcosine_sim, beidian_p2p_buy_wbcosine_sim, beidian_p2p_show_buy_wbcosine_sim, beidian_p2p_show_wbcosine_sim_today, beidian_p2p_show_wbcosine_sim_last_interval, beidian_p2p_show_wbcosine_sim_old_part, beidian_p2p_cart_wbcosine_sim_today, beidian_p2p_cart_wbcosine_sim_last_interval, beidian_p2p_cart_wbcosine_sim_old_part, beidian_p2p_buy_wbcosine_sim_today, beidian_p2p_buy_wbcosine_sim_last_interval, beidian_p2p_buy_wbcosine_sim_old_part, beidian_p2p_show_buy_wbcosine_sim_today, beidian_p2p_show_buy_wbcosine_sim_last_interval, beidian_p2p_show_buy_wbcosine_sim_old_part, beidian_item_action_log, beidian_item_show_cart_action_log, beidian_item_show_cart_action_log]\n" +
                "任务：hive2redis_beidian_guoyuan_hot_item 上游搜索与推荐组和广告组在线任务：[beidian_guoyuan_hot_item, beidian_online_items, beidian_online_items]\n" +
                "任务：beidian_i2i_recom_data_redis 上游搜索与推荐组和广告组在线任务：[beidian_i2i_recom_data, beidian_i2i_recom_data, beidian_online_items, beidian_p2p_recom_sim, beidian_p2p_recom_action_sim, beidian_p2p_recom_title_word2vec_sim_data_ext, beidian_p2p_show_wbcosine_sim, beidian_p2p_cart_wbcosine_sim, beidian_p2p_buy_wbcosine_sim, beidian_p2p_show_buy_wbcosine_sim, beidian_p2p_show_wbcosine_sim_today, beidian_p2p_show_wbcosine_sim_last_interval, beidian_p2p_show_wbcosine_sim_old_part, beidian_p2p_cart_wbcosine_sim_today, beidian_p2p_cart_wbcosine_sim_last_interval, beidian_p2p_cart_wbcosine_sim_old_part, beidian_p2p_buy_wbcosine_sim_today, beidian_p2p_buy_wbcosine_sim_last_interval, beidian_p2p_buy_wbcosine_sim_old_part, beidian_p2p_show_buy_wbcosine_sim_today, beidian_p2p_show_buy_wbcosine_sim_last_interval, beidian_p2p_show_buy_wbcosine_sim_old_part, beidian_item_action_log, beidian_item_show_cart_action_log, beidian_item_show_cart_action_log]\n";

        StringBuilder target = new StringBuilder();

//        strAll = strAll.replaceAll("：", "：,");
//        strAll2 = strAll2.replaceAll("：", "：,");
//        strAll3 = strAll3.replaceAll("：", "：,");
//        strAll4 = strAll4.replaceAll("：", "：,");
//        strAll5 = strAll5.replaceAll("：", "：,");

//        String[] strList = strAll.split(",");
//        for (String strFor : strList) {
//            if (target.toString().contains(strFor)) {
//                continue;
//            }
//            target.append(strFor).append(",");
//        }
//
//        String[] str2List = strAll2.split(",");
//        for (String strFor : str2List) {
//            if (target.toString().contains(strFor)) {
//                continue;
//            }
//            target.append(strFor).append(",");
//        }
//
//        String[] str3List = strAll3.split(",");
//        for (String strFor : str3List) {
//            if (target.toString().contains(strFor)) {
//                continue;
//            }
//            target.append(strFor).append(",");
//        }
//
//        String[] str4List = strAll4.split(",");
//        for (String strFor : str4List) {
//            if (target.toString().contains(strFor)) {
//                continue;
//            }
//            target.append(strFor).append(",");
//        }

        String[] str5List = str.split(",");
        for (String strFor : str5List) {
            if (target.toString().contains(strFor)) {
                continue;
            }
            target.append(strFor).append(",");
        }

        System.out.println(target);
    }
}
