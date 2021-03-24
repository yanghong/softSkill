package com.hunter.others;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/2/26 16:05
 */
public class TimeTest {

    public static void main(String[] args) {
//        String dumpDate = DateTime.now().toString("yyyy-MM-dd");
//        String yesterday = DateTime.now().minusDays(1).toString("yyyy-MM-dd");
//
//        System.out.println(dumpDate);
//        System.out.println(yesterday);


        String partition = "20210315/hr=17";

        System.out.println(partition.substring(0,8));

        List<String> partitions = Lists.newArrayList("20201029","20201030","20201031","20201112","20201113","20201114","20201115","20201117","20201118","20201119","20201120","20201121","20201122","20201123","20201124","20201125","20201126","20201127","20201128","20201129","20201130","20201201","20201202","20201203","20201204","20201205","20201206","20201207","20201208","20201209","20201210","20201211","20201212","20201213","20201214","20201215","20201216","20201217","20201218","20201219","20201220","20201221","20201222","20201223","20201224","20201225","20201226","20201227","20201228","20201229","20201230","20201231","20210101","20210102","20210103","20210104","20210105","20210106","20210107","20210108","20210109","20210110","20210111","20210112","20210113","20210114","20210115","20210116","20210117","20210118","20210119","20210120","20210121","20210122","20210123","20210124","20210125","20210126","20210127","20210128","20210129","20210130","20210131","20210201","20210202","20210203","20210204","20210205","20210206","20210207","20210208","20210209","20210210","20210211","20210212","20210213","20210214","20210215","20210216","20210217","20210218","20210219","20210220","20210221","20210222","20210223","20210224","20210225","20210226","20210227","20210228","20210301","20210302","20210303","20210304","20210305","20210306","20210307","20210308","20210309","20210310","20210311","20210312","20210313","20210314","20210317","20210318","20210319","20210320","20210321","20210322","20210323");
        List<String> validPartitions = filterPartition(partitions, 7);

        System.out.println(JSON.toJSONString(validPartitions));
    }


    private static List<String> filterPartition(List<String> partitions, Integer retention) {
        List<String> validPartitions = Lists.newArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        for (String partition : partitions) {
            try {
                // 分区时间
                Date date = simpleDateFormat.parse(partition);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                // 当前时间
                Date nowDate = new Date();

                // gap 天
                int gapDay = (int)((nowDate.getTime() - cal.getTimeInMillis()) /86400000);

                LocalDate startDate = date2LocalDate(date);
                LocalDate endDate = date2LocalDate(nowDate);

                long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);

                if (gapDay > retention) {

                    System.out.println("filterPartition gapDay : " + gapDay + " retention: " + retention);

                    validPartitions.add(partition);
                }

            } catch (Exception e) {
                System.out.println("时间转化异常" + e.getMessage());
            }
        }

        return validPartitions;
    }

    public static LocalDate date2LocalDate(Date date) {
        if(null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
