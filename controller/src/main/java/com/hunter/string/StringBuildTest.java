package com.hunter.string;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/29 10:27
 */
public class StringBuildTest {

    public static void main(String[] args) {

//        StringBuilder sb = new StringBuilder();
//
//        String name = "tbl_sd_dp_schedule_job_exec";
//
//        sb.append("\n" + name);
//
//        if (sb.length() > 0) {
//            System.out.println(" in trap!");
//        }


        String names = "\"dim_pub_test_usr_info\",\"dwb_trde_trade_s_d\",\"ods_bm09_member_s_d\",\"datax_mysql2hive_bp09_um_mycoupon_brand\",\"sqoop_mysql2hive_bb09_seller_info\",\"sqoop_mysql2hive_bt10_trade_payment\",\"sqoop_mysql2hive_ba09_item\",\"sqoop_mysql2hive_ba09_mart_mall\",\"ods_bb09_seller_info_s_d\",\"ods_ba09_mart_tuan_s_d\",\"ods_ba09_mart_show_s_d\",\"sqoop_mysql2hive_ba09_mart_show\",\"ods_ba09_mart_mall_oversea_s_d\",\"ods_ba09_mart_mall_s_d\",\"sqoop_mysql2hive_ba09_mart_oversea\",\"sqoop_mysql2hive_ba09_mart_mall_oversea\",\"sqoop_mysql2hive_bb09_mart_show_oversea\",\"sqoop_mysql2hive_bb09_category\",\"datax_mysql2hive_ba09_scene_change_log\",\"sqoop_mysql2hive_bb09_brand_detail\",\"sqoop_mysql2hive_bb09_wp_mall\",\"ods_bb09_mart_show_oversea_s_d\",\"sqoop_mysql2hive_ba09_mart_tuan\",\"ods_ba09_mart_oversea_s_d\",\"ods_bt10_trade_payment_s_d\",\"ods_bp09_c2c_um_mycoupon_s_d\",\"ods_bp09_um_mycoupon_brand_s_d\",\"ods_bp09_um_mycoupon_s_d\",\"ods_bt10_trade_s_d\",\"ods_ba09_item_s_d\"";

        String[] nameList = names.split(",");

        for (String nameEach : nameList) {
            System.out.println(nameEach);
        }

    }
}
