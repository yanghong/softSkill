package com.hunter.BizTest;

import com.alibaba.fastjson.JSON;
import com.hunter.BizTest.dwRule.Dimension;
import com.hunter.BizTest.dwRule.Indicator;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yanghong
 */
public class EncodeSqlTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String name =   "";
        String indicator =   "";
        String dimension =   "";
        String tableComment =   "";
        String storeType =   "";
        String fields =   "";
        String lines =   "";
        String collection =   "";
        String mapKey =  "";

        HashMap<String, String> sqlList = new HashMap<>();

        String sqlEncoded = "Y3JlYXRlIHRhYmxlIGlmIG5vdCBleGlzdHMgdG1wLnRtcF90cmRlX29yZGVyX3Rlc3RjbXNfdGVz\n" +
                "dGFfb2JtXzFkX2QKKAoJZnN0X2NydF90aW1lIHN0cmluZyBDT01NRU5UICLpppbmrKHliJvlu7ro\n" +
                "rqLljZXml7bpl7QiLAlsc3RfY3J0X3NyYyBzdHJpbmcgQ09NTUVOVCAi5pyA5ZCO5LiA5qyh5Yib\n" +
                "5bu66K6i5Y2V5p2l5rqQIgopCkNPTU1FTlQgIua1i+ivlSIKUEFSVElUSU9ORUQgQlkgKHB0IHN0\n" +
                "cmluZyBDT01NRU5UICJjZSIpClJPVyBGT1JNQVQgREVMSU1JVEVEClNUT1JFRCBBUyAKOw==";
        String sqlDecoded = Base64Utils.decode(sqlEncoded);
        sqlDecoded = sqlDecoded.replaceAll("%u", "\\\\u");
        String url = URLDecoder.decode(sqlDecoded, "UTF-8");
        String unicode = StringEscapeUtils.unescapeJava(url);

        String[] sqlSplit = unicode.split("\\(");
        int count = 0;
        for (String s : sqlSplit) {

            if (StringUtils.isNotBlank(s)) {
                System.out.println(count + s);
            }
            count++;
        }

        String nameMaterial = sqlSplit[0];
        String[] nameList = nameMaterial.split(" ");
        for (String n : nameList) {
            if (n.contains(".")) {
                name = n.split("\\.")[1];
                sqlList.put("name", name);
            }
        }

        String[] indicatorSpilt = sqlSplit[1].split("\\)");
        String indicatorMaterial = indicatorSpilt[0];
        String[] indicatorList = indicatorMaterial.split(",");
        for (String i : indicatorList) {
            indicator = indicator + i.replace("\n", "") + ",";
        }

        String otherPart = "";
        if (StringUtils.isNotBlank(indicator)) {
            indicator = parseIndicator(indicator);
            sqlList.put("indicator", indicator);
            otherPart = sqlSplit[1].split("\\)")[1];
        }

        String otherMaterial = otherPart + sqlSplit[2];
        String[] otherList = otherMaterial.split("\n");
        for (String s : otherList) {
            if (s.startsWith("COMMENT") && StringUtils.isNotBlank(s)) {
                tableComment = s.split(" ")[1];
                sqlList.put("tableComment", tableComment.replaceAll("\"", ""));
            }
            if (s.startsWith("PARTITIONED BY") && StringUtils.isNotBlank(s)) {
                dimension = parseDimension(s);
                sqlList.put("dimension", dimension);
            }
            if (s.startsWith("STORED AS") && StringUtils.isNotBlank(s)) {
                storeType = s.replace("STORED AS ", "");
                sqlList.put("storeType", storeType);
            }
            if (s.startsWith("FIELDS TERMINATED BY") && StringUtils.isNotBlank(s)) {
                fields = s.replace("FIELDS TERMINATED BY ", "").replace("\"","");
                sqlList.put("fields", fields);
            }
            if (s.startsWith("LINES TERMINATED BY") && StringUtils.isNotBlank(s)) {
                lines = s.replace("LINES TERMINATED BY ", "").replace("\"","");
                sqlList.put("lines", lines);
            }
            if (s.startsWith("COLLECTION ITEMS TERMINATED BY") && StringUtils.isNotBlank(s)) {
                collection = s.replace("COLLECTION ITEMS TERMINATED BY ", "").replace("\"","");
                sqlList.put("collection", collection);
            }
            if (s.startsWith("MAP KEYS TERMINATED BY") && StringUtils.isNotBlank(s)) {
                mapKey = s.replace("MAP KEYS TERMINATED BY ", "").replace("\"","");
                sqlList.put("mapKey", mapKey);
            }
        }

        System.out.println(sqlList.toString());

    }

    private static String parseDimension(String dimension) {

        List<Dimension> dimResultList = new ArrayList<>();
        dimension = dimension.replaceAll("PARTITIONED BY ", "").replace("COMMENT ", "").replace(")","");
        String[] dimList = dimension.split(",");

        for (String d : dimList) {
            if (StringUtils.isNotBlank(d)) {
                Dimension dim = new Dimension();
                String[] dList = d.split(" ");
                dim.setName(dList[0]);
                dim.setType(dList[1]);
                dim.setComment(dList[2].replace("\"", ""));
                dim.setPartition(true);
                dimResultList.add(dim);
            }
        }
        return JSON.toJSONString(dimResultList);
    }

    private static String parseIndicator(String indicator) {

        List<Indicator> indicators = new ArrayList<>();

        try {
            String[] indicatorList = indicator.split(",");
            for (String i : indicatorList) {
                if (StringUtils.isNotBlank(i)) {
                    Indicator indicator1 = new Indicator();
                    i = i.replace("COMMENT", "").trim();

                    Pattern p = Pattern.compile("\\s+");
                    Matcher m = p.matcher(i);
                    i= m.replaceAll(" ");

                    String[] iList = i.split(" ");
                    indicator1.setName(iList[0].trim());
                    indicator1.setType(iList[1].trim());

                    try {
                        indicator1.setComment(iList[2].trim().replace("\"", ""));
                    } catch (Exception e) {
                        System.out.println("数据化规约解析indeicators iList 2报错： " + JSON.toJSONString(e));
                    }

                    indicator1.setPartition(false);
                    indicators.add(indicator1);
                }
            }
        } catch (Exception e) {
            System.out.println("数据化规约解析indeicators报错： "+ JSON.toJSONString(e));
        }

        return JSON.toJSONString(indicators);
    }


}
