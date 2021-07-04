package com.hunter.BizTest;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yanghong
 */
public class GeneratorSqlTest {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String name = "datax_asas";
        String indicator = "[{\"name\":\"test_crt_ord_cnt_1d\",\"type\":\"string\",\"COMMENT\":\"测\",\"partition\":false}]";
        String dimension = "[{\"name\":\"1_437_336_336\",\"type\":\"double\",\"COMMENT\":\"测\",\"partition\":true},{\"name\":\"tttt\",\"type\":\"double\",\"COMMENT\":\"测\",\"partition\":false}]";
        String tableComment = "c";
        String storeType = "textfile";
        String fields = "1";
        String lines = "1";
        String collection = "1";
        String mapKey = "1";

        // 表名
        String[] nameList = name.split("_");
        result.append("create table if not exists ").append(nameList[0]).append(".").append(name).append("\n");
        result.append("(").append("\n");

        List<Dimension> dimArr = JSONArray.parseArray(dimension, Dimension.class);
        List<Indicator> dataArr = JSONArray.parseArray(indicator, Indicator.class);

        List<Dimension> partitionedDimArr = Lists.newArrayList();

        for (Dimension dim : dimArr) {
            if (!dim.isPartition()) {
                Indicator in = new Indicator();
                in.setComment(dim.getComment());
                in.setName(dim.getName());
                in.setPartition(dim.isPartition());
                in.setType(dim.getType());
                dataArr.add(in);
            } else {
                partitionedDimArr.add(dim);
            }
        }
        // 添加派生指标、原子指标等

        if (null != dataArr) {
            for (int i = 0; i < dataArr.size(); i++) {
                result.append("\t");
                result.append(dataArr.get(i).getName()).append(" ");
                result.append(dataArr.get(i).getType()).append(" ");
                result.append("COMMENT \"");
                result.append(dataArr.get(i).getComment()).append("\"");
                if (i != dataArr.size() - 1) {
                    result.append(",\n");
                }
            }
        }

        result.append("\n)").append("\n");
        // 表注释
        result.append("COMMENT \"").append(tableComment).append("\"\n");

        // 维度  PARTITIONED BY (pt  COMMENT "日期分区",hr  COMMENT "小时分区")
        result.append("PARTITIONED BY (");
        if (partitionedDimArr.size() > 0) {
            for (int i = 0; i < partitionedDimArr.size(); i++) {
                if (partitionedDimArr.get(i).isPartition()) {
                    result.append(partitionedDimArr.get(i).getName()).append(" ");
                    result.append(partitionedDimArr.get(i).getType()).append(" ");
                    result.append("COMMENT \"");
                    result.append(partitionedDimArr.get(i).getComment()).append("\"");
                    if (i != partitionedDimArr.size() - 1) {
                        result.append(",");
                    }
                }
            }
        }
        result.append(")");
        result.append("\n");
        result.append("ROW FORMAT DELIMITED").append("\n");

        boolean flag = false;

        // 字段分隔符  FIELDS TERMINATED BY "12"
        if (null != fields) {
            flag = true;
            result.append("FIELDS TERMINATED BY \"").append(fields).append("\"\n");
        }

        // 行分隔符  LINES TERMINATED BY "43"
        if (null != lines) {
            flag = true;
            result.append("LINES TERMINATED BY \"").append(lines).append("\"\n");
        }

        // 集合分隔符  COLLECTION ITEMS TERMINATED BY "453"
        if (null != collection) {
            flag = true;
            result.append("COLLECTION ITEMS TERMINATED BY \"").append(collection).append("\"\n");
        }

        // MAPKEY分隔符   MAP KEYS TERMINATED BY "6665"
        if (null != mapKey) {
            flag = true;
            result.append("MAP KEYS TERMINATED BY \"").append(mapKey).append("\"\n");
        }

        if (!flag) {
            result = new StringBuilder(result.toString().replace("ROW FORMAT DELIMITED\n", ""));
        }

        // 存储格式
        if (null != storeType) {
            result.append("STORED AS ").append(storeType).append("\n");
        } else {
            result.append("STORED AS ").append("ORC").append("\n");
        }
        result.append(";");

        String resultStr = result.toString().replaceAll("\n", "<br/>");

        System.out.println(resultStr);
    }

    static class Indicator{
        private String name;
        private String type;
        private String comment;
        private boolean partition;

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

        public boolean isPartition() {
            return partition;
        }

        public void setPartition(boolean partition) {
            this.partition = partition;
        }
    }

    static class Dimension {

        private String name;
        private String type;
        private String comment;
        private boolean partition;

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

        public boolean isPartition() {
            return partition;
        }

        public void setPartition(boolean partition) {
            this.partition = partition;
        }
    }
}
