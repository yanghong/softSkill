package com.hunter.BizTest.sql.analysis;

import com.google.common.collect.Sets;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Analysis {

    public static String dimString = "ods,rods,dwd,dws,app,rpt,dwb,stage,adm,sadm,fdm,udm,dim";

    private static String SQL = "-- ***************************************************************\n" +
            "-- 所属主题：\n" +
            "-- 功能描述：贝管家会员激励应用\n" +
            "-- 创建者：jiahua.zhu\n" +
            "-- 创建日期：20191203\n" +
            "-- 修改日期  修改人  修改内容\n" +
            "-- doc: http://doc.beibei.com.cn/pages/viewpage.action?pageId=114536152\n" +
            "-- v2 104470\n" +
            "-- v3  5071\n" +
            "-- 近两个月没有新增店主的v2服务商 92304\n" +
            "-- 接口地址\n" +
            "-- http://opsea.bigdata.beibei.com.cn/opseaweb/interface/detail/753\n" +
            "-- ***************************************************************\n" +
            "-- app_bdian_bgj_ripe_servicer_award_df 成熟奖励计划[P1]\n" +
            "-- app_bdian_bgj_new_servicer_award_df 新晋奖励计划[P1]\n" +
            "-- 成为服务商时间 dwb_usr_bd_member_info_s_d 表中的  gold_time（v2服务商时间） 和 diamond_time（v3服务商时间）\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS app.app_bdian_bgj_servicer_award_df\n" +
            "(\n" +
            "   stat_date                        bigint  comment '统计时间'      \n" +
            "  ,uid                              bigint  comment 'uid'\n" +
            "  ,servicer_type                    bigint  comment '服务商等级类型'\n" +
            "  ,team_retail_amt_1m               decimal(22,2) comment '社群本月销售额'\n" +
            "  ,team_retail_amt_1m_rank          bigint  comment '本月社群零售额排名 分组按照服务商等级类型'\n" +
            "  ,shop_retail_amt_1m               decimal(22,2) comment '个人本月销售额'\n" +
            "  ,usr_flag                         bigint  comment '服务商类型标识 0: 新晋服务商，1: 成熟服务商'\n" +
            "  ,diamond_time                     string  comment '成为v3的时间'\n" +
            "  ,gold_time                        string  comment '成为v2的时间'\n" +
            ")\n" +
            "COMMENT '贝管家会员激励应用列表'\n" +
            "partitioned by (pt bigint)\n" +
            "stored as orc;\n" +
            "\n" +
            "-- dwb_usr_bd_member_info_s_d\n" +
            "-- show create table dwb_usr_bd_member_info_s_d\n" +
            "\n" +
            "-- 成熟 v2 服务商\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0101;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0101 as\n" +
            "SELECT\n" +
            "t1.uid\n" +
            ",gold_time\n" +
            ",diamond_time\n" +
            ",user_type\n" +
            ",award_shop_retail_amt_1m\n" +
            ",team_retail_amt_1m_vip\n" +
            "from \n" +
            "(\n" +
            "    select \n" +
            "    uid\n" +
            "    ,charge_time gold_time\n" +
            "    ,manager_time diamond_time\n" +
            "    ,user_type\n" +
            "    from dim.dim_user_mbr_bdian \n" +
            "    where pt = ${bizdate} \n" +
            "    and charge_time <> '0000-00-00 00:00:00' \n" +
            "    and charge_time < ${DynamicDate,\"yyyy-MM-01\",M,-3}\n" +
            "    and manager_time ='0000-00-00 00:00:00' and user_type = 2\n" +
            "    AND uid not in (#{bgj_servicer_award_not_uid})\n" +
            ") t1\n" +
            "left join \n" +
            "(\n" +
            "    select \n" +
            "    uid\n" +
            "    ,award_shop_retail_amt_1m\n" +
            "    ,team_retail_amt_1m_vip -- 社群零售额\n" +
            "    from\n" +
            "    dws.dws_usr_bd_wygj_shop_stat_s_hr\n" +
            "    where pt = ${bizdate} \n" +
            ") t2\n" +
            "on t1.uid = t2.uid\n" +
            ";\n" +
            "\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_01;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_01 as\n" +
            "select uid\n" +
            ", user_type servicer_type\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else award_shop_retail_amt_1m end shop_retail_amt_1m\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else team_retail_amt_1m_vip end team_retail_amt_1m\n" +
            ", row_number() over (order by team_retail_amt_1m_vip desc) team_retail_amt_1m_rank\n" +
            ", diamond_time\n" +
            ", gold_time\n" +
            ", 1 usr_flag\n" +
            "from\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0101\n" +
            "where award_shop_retail_amt_1m >= 800\n" +
            "union ALL\n" +
            "select uid\n" +
            ", user_type servicer_type\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else award_shop_retail_amt_1m end shop_retail_amt_1m\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else team_retail_amt_1m_vip end team_retail_amt_1m\n" +
            ", 999999 team_retail_amt_1m_rank\n" +
            ", diamond_time\n" +
            ", gold_time\n" +
            ", 1 usr_flag\n" +
            "from\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0101\n" +
            "where award_shop_retail_amt_1m < 800\n" +
            ";\n" +
            "\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0201;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0201 as\n" +
            "select\n" +
            "t1.uid\n" +
            ",gold_time\n" +
            ",diamond_time\n" +
            ",user_type\n" +
            ",award_shop_retail_amt_1m\n" +
            ",team_retail_amt_1m_vip\n" +
            "FROM\n" +
            "(\n" +
            "    select \n" +
            "    uid\n" +
            "    ,charge_time gold_time\n" +
            "    ,manager_time diamond_time\n" +
            "    ,user_type\n" +
            "    from dim.dim_user_mbr_bdian \n" +
            "    where pt = ${bizdate} \n" +
            "    and manager_time <>'0000-00-00 00:00:00'\n" +
            "    and manager_time < ${DynamicDate,\"yyyy-MM-01\",M,-3} and user_type = 3\n" +
            "    and uid not in (#{bgj_servicer_award_not_uid})\n" +
            ") t1\n" +
            "left join \n" +
            "(\n" +
            "    select \n" +
            "    uid\n" +
            "    ,award_shop_retail_amt_1m\n" +
            "    ,team_retail_amt_1m_vip -- 社群零售额\n" +
            "    from\n" +
            "    dws.dws_usr_bd_wygj_shop_stat_s_hr\n" +
            "    where pt = ${bizdate} \n" +
            ") t2\n" +
            "on t1.uid = t2.uid\n" +
            ";\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_02;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_02 as\n" +
            "select uid\n" +
            ", user_type servicer_type\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else award_shop_retail_amt_1m end shop_retail_amt_1m\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else team_retail_amt_1m_vip end team_retail_amt_1m\n" +
            ", row_number() over (order by team_retail_amt_1m_vip desc) team_retail_amt_1m_rank\n" +
            ", diamond_time\n" +
            ", gold_time\n" +
            ", 1 usr_flag\n" +
            "from\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0201\n" +
            "where award_shop_retail_amt_1m >= 800\n" +
            "UNION ALL\n" +
            "select uid\n" +
            ", user_type servicer_type\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else award_shop_retail_amt_1m end shop_retail_amt_1m\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else team_retail_amt_1m_vip end team_retail_amt_1m\n" +
            ", 999999 team_retail_amt_1m_rank\n" +
            ", diamond_time\n" +
            ", gold_time\n" +
            ", 1 usr_flag\n" +
            "from\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0201\n" +
            "where award_shop_retail_amt_1m < 800\n" +
            ";\n" +
            "\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0301;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0301 as\n" +
            "SELECT\n" +
            "t1.uid\n" +
            ",gold_time\n" +
            ",diamond_time\n" +
            ",user_type\n" +
            ",award_shop_retail_amt_1m\n" +
            ",team_retail_amt_1m_vip\n" +
            "from\n" +
            "(\n" +
            "    select \n" +
            "    uid\n" +
            "    ,charge_time gold_time\n" +
            "    ,manager_time diamond_time\n" +
            "    ,user_type\n" +
            "    from dim.dim_user_mbr_bdian \n" +
            "    where pt = ${bizdate} \n" +
            "    and charge_time > ${DynamicDate,\"yyyy-MM-01\",M,-3}\n" +
            "    and user_type = 2 and uid not in (#{bgj_servicer_award_not_uid})\n" +
            ") t1\n" +
            "left join \n" +
            "(\n" +
            "    select \n" +
            "    uid\n" +
            "    ,award_shop_retail_amt_1m\n" +
            "    ,team_retail_amt_1m_vip -- 社群零售额\n" +
            "    from\n" +
            "    dws.dws_usr_bd_wygj_shop_stat_s_hr\n" +
            "    where pt = ${bizdate} \n" +
            ") t2\n" +
            "on t1.uid = t2.uid;\n" +
            "\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_03;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_03 as\n" +
            "-- 新晋 v2\n" +
            "select \n" +
            "uid\n" +
            ", user_type servicer_type\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else award_shop_retail_amt_1m end shop_retail_amt_1m\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else team_retail_amt_1m_vip end team_retail_amt_1m\n" +
            ", row_number() over (order by team_retail_amt_1m_vip desc) team_retail_amt_1m_rank\n" +
            ", diamond_time\n" +
            ", gold_time\n" +
            ", 0 usr_flag\n" +
            "from\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0301\n" +
            "where award_shop_retail_amt_1m >= 800\n" +
            "UNION all\n" +
            "select \n" +
            "uid\n" +
            ", user_type servicer_type\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else award_shop_retail_amt_1m end shop_retail_amt_1m\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else team_retail_amt_1m_vip end team_retail_amt_1m\n" +
            ", 999999 team_retail_amt_1m_rank\n" +
            ", diamond_time\n" +
            ", gold_time\n" +
            ", 0 usr_flag\n" +
            "from\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0301\n" +
            "where award_shop_retail_amt_1m < 800\n" +
            ";\n" +
            "\n" +
            "\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0401;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0401 as\n" +
            "SELECT\n" +
            "t1.uid\n" +
            ",gold_time\n" +
            ",diamond_time\n" +
            ",user_type\n" +
            ",award_shop_retail_amt_1m\n" +
            ",team_retail_amt_1m_vip -- 社群零售额\n" +
            "from\n" +
            "(\n" +
            "    select \n" +
            "    uid\n" +
            "    ,charge_time gold_time\n" +
            "    ,manager_time diamond_time\n" +
            "    ,user_type\n" +
            "    from dim.dim_user_mbr_bdian \n" +
            "    where pt = ${bizdate} \n" +
            "    and manager_time > ${DynamicDate,\"yyyy-MM-01\",M,-3} \n" +
            "    and user_type = 3 and uid not in (#{bgj_servicer_award_not_uid})\n" +
            ") t1\n" +
            "left join \n" +
            "(\n" +
            "    select \n" +
            "    uid\n" +
            "    ,award_shop_retail_amt_1m\n" +
            "    ,team_retail_amt_1m_vip -- 社群零售额\n" +
            "    from\n" +
            "    dws.dws_usr_bd_wygj_shop_stat_s_hr\n" +
            "    where pt = ${bizdate} \n" +
            ") t2\n" +
            "on t1.uid = t2.uid;\n" +
            "-- 新晋 v3\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_04;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_04 as\n" +
            "\n" +
            "select uid\n" +
            ", user_type servicer_type\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else award_shop_retail_amt_1m end shop_retail_amt_1m\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else team_retail_amt_1m_vip end team_retail_amt_1m\n" +
            ", row_number() over (order by team_retail_amt_1m_vip desc) team_retail_amt_1m_rank\n" +
            ", diamond_time\n" +
            ", gold_time\n" +
            ", 0 usr_flag\n" +
            "from\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0401\n" +
            "where award_shop_retail_amt_1m >= 800\n" +
            "UNION ALL\n" +
            "select uid\n" +
            ", user_type servicer_type\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else award_shop_retail_amt_1m end shop_retail_amt_1m\n" +
            ", case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else team_retail_amt_1m_vip end team_retail_amt_1m\n" +
            ", 999999 team_retail_amt_1m_rank\n" +
            ", diamond_time\n" +
            ", gold_time\n" +
            ", 0 usr_flag\n" +
            "from\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0401\n" +
            "where award_shop_retail_amt_1m < 800\n" +
            ";\n" +
            "\n" +
            "\n" +
            "-- 金牌 v2 近两个月\n" +
            "-- 拓展奖励满足条件的服务商归属\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0501;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0501 as\n" +
            "select t1.father_uid uid\n" +
            "    , t1.user_type servicer_type\n" +
            "    , sum(case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else award_shop_retail_amt_1m end) team_retail_amt_1m\n" +
            "    , 2 usr_flag\n" +
            "    from\n" +
            "    (\n" +
            "        select \n" +
            "        charge_uid father_uid\n" +
            "        , 2 user_type\n" +
            "        , uid \n" +
            "        from dim.dim_user_mbr_bdian \n" +
            "        where pt = ${bizdate}\n" +
            "        and shop_time > ${DynamicDate,\"yyyy-MM-01\",M,-1} \n" +
            "        and charge_uid<>manager_uid\n" +
            "    ) t1\n" +
            "    left join \n" +
            "    (\n" +
            "        select \n" +
            "        uid\n" +
            "        ,award_shop_retail_amt_1m\n" +
            "        from\n" +
            "        dws.dws_usr_bd_wygj_shop_stat_s_hr\n" +
            "        where pt = ${bizdate}\n" +
            "    ) t2\n" +
            "    on t1.uid = t2.uid\n" +
            "    group by father_uid, t1.user_type;\n" +
            "\n" +
            "--\n" +
            "\n" +
            "-- 获取服务商的个人零售额\n" +
            "\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_050101;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_050101 as\n" +
            "select t2.uid\n" +
            "    , t2.user_type servicer_type\n" +
            "    , t2.award_shop_retail_amt_1m shop_retail_amt_1m\n" +
            "    , t1.team_retail_amt_1m\n" +
            "    , usr_flag\n" +
            "    from \n" +
            "    (\n" +
            "        select uid\n" +
            "            ,team_retail_amt_1m\n" +
            "            ,usr_flag \n" +
            "            ,servicer_type\n" +
            "        from tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0501 \n" +
            "        where uid not in (#{bgj_servicer_award_not_uid})\n" +
            "    ) t1\n" +
            "    right join \n" +
            "    (\n" +
            "        select \n" +
            "        uid\n" +
            "        ,award_shop_retail_amt_1m\n" +
            "        ,user_type\n" +
            "        from\n" +
            "        dws.dws_usr_bd_wygj_shop_stat_s_hr\n" +
            "        where pt = ${bizdate} and user_type = 2 and charge_uid <> manager_uid\n" +
            "    ) t2\n" +
            "on t1.uid = t2.uid\n" +
            ";\n" +
            "\n" +
            "\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_05;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_05 as\n" +
            "select uid \n" +
            ", servicer_type\n" +
            ", shop_retail_amt_1m\n" +
            ", team_retail_amt_1m\n" +
            ", row_number() over (order by team_retail_amt_1m desc) team_retail_amt_1m_rank\n" +
            ", '' diamond_time\n" +
            ", '' gold_time\n" +
            ", usr_flag\n" +
            "from \n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_050101\n" +
            "where shop_retail_amt_1m >= 800 and team_retail_amt_1m is not null\n" +
            "UNION ALL\n" +
            "select uid \n" +
            ", servicer_type\n" +
            ", shop_retail_amt_1m\n" +
            ", nvl(team_retail_amt_1m, 0)\n" +
            ", 999999 team_retail_amt_1m_rank\n" +
            ", '' diamond_time\n" +
            ", '' gold_time\n" +
            ", 2 usr_flag\n" +
            "from \n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_050101\n" +
            "where shop_retail_amt_1m < 800 or team_retail_amt_1m is null\n" +
            ";\n" +
            "\n" +
            "--- v3\n" +
            "\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0601;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0601 as\n" +
            "    select t1.father_uid uid\n" +
            "    , t1.user_type servicer_type\n" +
            "    , sum(case when dayofmonth(${DynamicDate,\"yyyy-MM-dd\",D,0})=1 then 0 else award_shop_retail_amt_1m end) team_retail_amt_1m\n" +
            "    , 2 usr_flag\n" +
            "    from\n" +
            "    (\n" +
            "        select manager_uid father_uid\n" +
            "            ,3 user_type\n" +
            "            ,uid\n" +
            "            ,shop_time rlat_create_time \n" +
            "        from dim.dim_user_mbr_bdian \n" +
            "        where pt = ${bizdate}\n" +
            "        and shop_time > ${DynamicDate,\"yyyy-MM-01\",M,-1} \n" +
            "\n" +
            "    ) t1\n" +
            "    left join \n" +
            "    (\n" +
            "        select \n" +
            "        uid\n" +
            "        ,award_shop_retail_amt_1m\n" +
            "        from\n" +
            "        dws.dws_usr_bd_wygj_shop_stat_s_hr\n" +
            "        where pt = ${bizdate} \n" +
            "    ) t2\n" +
            "    on t1.uid = t2.uid\n" +
            "    group by father_uid, t1.user_type;\n" +
            "\n" +
            "-- 获取v3服务商真实个人销售额\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_060101;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_060101 as\n" +
            "select t2.uid\n" +
            "    , t2.user_type servicer_type\n" +
            "    , t2.award_shop_retail_amt_1m shop_retail_amt_1m\n" +
            "    , t1.team_retail_amt_1m\n" +
            "    , usr_flag\n" +
            "    from \n" +
            "    (\n" +
            "        select uid\n" +
            "            ,team_retail_amt_1m\n" +
            "            ,usr_flag \n" +
            "            ,servicer_type\n" +
            "        from tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_0601 \n" +
            "        where uid not in (#{bgj_servicer_award_not_uid})\n" +
            "    ) t1\n" +
            "    right join \n" +
            "    (\n" +
            "        select \n" +
            "        uid\n" +
            "        ,award_shop_retail_amt_1m\n" +
            "        ,user_type\n" +
            "        from\n" +
            "        dws.dws_usr_bd_wygj_shop_stat_s_hr\n" +
            "        where pt = ${bizdate} and user_type = 3\n" +
            "    ) t2\n" +
            "on t1.uid = t2.uid\n" +
            ";\n" +
            "\n" +
            "\n" +
            "drop table if exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_06;\n" +
            "create table if not exists tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_06 as\n" +
            "select uid \n" +
            ", servicer_type\n" +
            ", shop_retail_amt_1m\n" +
            ", team_retail_amt_1m\n" +
            ", row_number() over (order by team_retail_amt_1m desc) team_retail_amt_1m_rank\n" +
            ", '' diamond_time\n" +
            ", '' gold_time\n" +
            ", usr_flag\n" +
            "from \n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_060101\n" +
            "WHERE\n" +
            "shop_retail_amt_1m >=800 and team_retail_amt_1m is not null\n" +
            "UNION ALL\n" +
            "select uid \n" +
            ", servicer_type\n" +
            ", shop_retail_amt_1m\n" +
            ", nvl(team_retail_amt_1m, 0)\n" +
            ", 999999 team_retail_amt_1m_rank\n" +
            ", '' diamond_time\n" +
            ", '' gold_time\n" +
            ", 2 usr_flag\n" +
            "from \n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_060101\n" +
            "WHERE\n" +
            "shop_retail_amt_1m < 800 or team_retail_amt_1m is null\n" +
            "\n" +
            ";\n" +
            "\n" +
            "\n" +
            "-- 汇总 -- \n" +
            "\n" +
            "alter table app.app_bdian_bgj_servicer_award_df drop if exists partition(pt=${bizdate});\n" +
            "insert overwrite table app.app_bdian_bgj_servicer_award_df partition(pt = ${bizdate})\n" +
            "select \n" +
            "    ${bizdate} stat_date\n" +
            "    ,uid \n" +
            "    ,servicer_type\n" +
            "    ,team_retail_amt_1m\n" +
            "    ,team_retail_amt_1m_rank\n" +
            "    ,shop_retail_amt_1m\n" +
            "    ,usr_flag\n" +
            "    ,diamond_time\n" +
            "    ,gold_time\n" +
            "FROM\n" +
            "(\n" +
            "select * FROM\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_01\n" +
            "union ALL\n" +
            "select * FROM\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_02\n" +
            "UNION ALL\n" +
            "select * FROM\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_03\n" +
            "union all\n" +
            "select * FROM\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_04\n" +
            "union all\n" +
            "select * FROM\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_05\n" +
            "union all\n" +
            "select * FROM\n" +
            "tmp.tmp_app_bdian_bgj_servicer_award_df_${bizdate}_06\n" +
            ") t;\n";

    public static void main(String[] args) {

        String s = SQL.replace("\n", " ").replaceAll("\\s+"," ");
        String[] appSplit = s.split(" ");
        Set<String> targetList = Sets.newHashSet();

        for (String str : appSplit) {
            if (str.contains(".")) {
                List<String> pointList = Arrays.asList(str.split("\\."));
                if (CollectionUtils.isEmpty(pointList)) {
                    continue;
                }
                for (String point : pointList) {
                    if (inTargetCondition(point)) {
                        targetList.add(str);
                    }
                }
            }
        }

        System.out.println(targetList.toString());

    }

    private static boolean inTargetCondition(String point) {
        String[] dimList = dimString.split(",");

        for (String dim : dimList) {
            if (dim.equals(point)) {
                return true;
            }
        }
        return false;
    }
}
