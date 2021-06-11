package com.hunter.BizTest;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * @author yanghong
 */
public class GeneratorSqlTest {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String name = "dws_prod_dws_2m_m";
        String indicator = "[{\"name\":\"crt_trd_cnt_1d\",\"type\":\"bigint\",\"COMMENT\":\"最近一天下单交易数\"}]";
        String dimension = "[{\"name\":\"hr\",\"type\":\"bigint\",\"COMMENT\":\"小时分区\"},{\"name\":\"pt\",\"type\":\"bigint\",\"COMMENT\":\"日期分区\"}]";
        String tableComment = "测试一下";
        String storeType = "TEXTFILE";
        String fields = "32432";
        String lines = "2332";
        String collection = "111";
        String mapKey = "555";

        // 表名
        String[] nameList = name.split("_");
        result.append("create table if not exists ").append(nameList[0]).append(".").append(name).append("\n");
        result.append("(").append("\n");
        // 添加派生指标、原子指标等
        List<Indicator> dataArr = JSONArray.parseArray(indicator, Indicator.class);
        if (null != dataArr) {
            for (int i = 0; i < dataArr.size(); i++) {
                result.append("\t");
                result.append(dataArr.get(i).getName()).append(" ");
                result.append(dataArr.get(i).getType()).append(" ");
                result.append("COMMENT \"");
                result.append(dataArr.get(i).getComment()).append("\"");
                if (i != dataArr.size() - 1) {
                    result.append(",");
                }
            }
        }

        result.append("\n)").append("\n");
        // 表注释
        result.append("COMMENT \"").append(tableComment).append("\"\n");

        // 维度  PARTITIONED BY (pt  COMMENT "日期分区",hr  COMMENT "小时分区")
        List<Dimension> dimArr = JSONArray.parseArray(dimension, Dimension.class);
        result.append("PARTITIONED BY (");
        if (null != dimArr) {
            for (int i = 0; i < dimArr.size(); i++) {
                result.append(dimArr.get(i).getName()).append(" ");
                result.append(dimArr.get(i).getType()).append(" ");
                result.append("COMMENT \"");
                result.append(dimArr.get(i).getComment()).append("\"");
                if (i != dimArr.size() - 1) {
                    result.append(",");
                }
            }
        }
        result.append("\n");
        result.append("ROW FORMAT DELIMITED").append("\n");

        // 字段分隔符  FIELDS TERMINATED BY "12"
        if (null != fields) {
            result.append("FIELDS TERMINATED BY \"").append(fields).append("\"\n");
        }

        // 行分隔符  LINES TERMINATED BY "43"
        if (null != lines) {
            result.append("LINES TERMINATED BY \"").append(lines).append("\"\n");
        }

        // 集合分隔符  COLLECTION ITEMS TERMINATED BY "453"
        if (null != collection) {
            result.append("COLLECTION ITEMS TERMINATED BY \"").append(collection).append("\"\n");
        }

        // MAPKEY分隔符   MAP KEYS TERMINATED BY "6665"
        if (null != mapKey) {
            result.append("MAP KEYS TERMINATED BY \"").append(mapKey).append("\"\n");
        }

        // 存储格式
        if (null != storeType) {
            result.append("STORED AS ").append(storeType).append("\n");
        } else {
            result.append("STORED AS ").append("ORC").append("\n");
        }
        result.append(";");

        System.out.println(result.toString());
    }

    static class Indicator{
        private String name;
        private String type;
        private String comment;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    static class Dimension {

        private String name;
        private String type;
        private String comment;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
