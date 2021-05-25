package com.hunter.BizTest;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/14 17:59
 */
public class Test {

    public static void main(String[] args) {
//        String jobInfo = "dwd_";
//        String baifenhao = "%";
//        jobInfo =  String.format("'%s'", jobInfo.replace(",", "|"));
//        jobInfo = jobInfo + '%';
//        System.out.println(jobInfo.replace("'%", "%'"));
//
//        Set<Long> testSet = new HashSet();
//
//        System.out.println(testSet.contains(1L));

//        String from = "2021-04-01";
//
//        String to = "2021-04-02";
//
//        String schConfId = "123123";
//
//        String sql = " SELECT"
//                + " status"
//                + " FROM"
//                + " `tbl_sd_schedule_job_exec`"
//                + " WHERE"
//                + " init_time < '" + to + "'"
//                + " AND sch_conf_id = " + schConfId
//                + " AND STATUS = 4";
//        if(StringUtils.isNotBlank(from)) {
//            sql += " AND init_time > '" + from +"'";
//        } else {
//            sql += " AND init_time > '" + DateTime.now().toString("yyyy-MM-dd 00:00:00") +"'";
//        }
//
//        System.out.println(sql);


//        String message = "message";
//        String classN = Test.class.getName() + ":";
//        Date date = new Date();
//        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String item = sformat.format(date);
//
//        SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd");
//        String logDate = sfm.format(date);
//
//        String str = item + " " + classN + message + "\n";
//
//        String path = "/opt/tomcat7/tmp/lifecycle.log." + logDate;
//
//        System.out.printf(path);

        Calendar calendar = Calendar.getInstance();

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println(dayOfMonth);

    }
}
