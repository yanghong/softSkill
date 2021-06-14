package com.hunter.BizTest;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
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

        String sqlEncoded = "Y3JlYXRlJTIwdGFibGUlMjBpZiUyMG5vdCUyMGV4aXN0cyUyMGR3cy5kd3NfZmxvd19kd3NfMndfdyUwQSUyOCUwQSUyMCUyMCUyMCUyMCUyMHB0JTIwJTIwJTIwJTIwYmlnaW50JTIwJTIwJTIwJTIwQ09NTUVOVCUyMCUyMiV1NjVFNSV1NjcxRiV1NTIwNiV1NTMzQSUyMiUwQSUyMCUyMCUyMCUyMCUyQ2hyJTIwJTIwJTIwJTIwYmlnaW50JTIwJTIwJTIwJTIwQ09NTUVOVCUyMCUyMiV1NUMwRiV1NjVGNiV1NTIwNiV1NTMzQSUyMiUwQSUyMCUyMCUyMCUyMCUyQ2NydF90cmRfY250XzFkJTIwJTIwJTIwJTIwYmlnaW50JTIwJTIwJTIwJTIwQ09NTUVOVCUyMCUyMiV1NjcwMCV1OEZEMSV1NEUwMCV1NTkyOSV1NEUwQiV1NTM1NSV1NEVBNCV1NjYxMyV1NjU3MCUyMiUwQSUwQSUyOSUwQUNPTU1FTlQlMjAlMjIldTZENEIldThCRDUlMjIlMEFQQVJUSVRJT05FRCUyMEJZJTIwJTI4cHQlMjBiaWdpbnQlMjBDT01NRU5UJTIwJTIyJXU2NUU1JXU2NzFGJXU1MjA2JXU1MzNBJTIyJTJDaHIlMjBiaWdpbnQlMjBDT01NRU5UJTIwJTIyJXU1QzBGJXU2NUY2JXU1MjA2JXU1MzNBJTIyJTI5JTBBU1RPUkVEJTIwQVMlMjBvcmMlMEElM0I=";
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
            }
        }

        String[] indicatorSpilt = sqlSplit[1].split("\\)");
        String indicatorMaterial = indicatorSpilt[0];
        String[] indicatorList = indicatorMaterial.split(",");
        for (String i : indicatorList) {
            indicator = indicator + i.replace("\n", "") + ",";
        }

        indicator = parseIndicator(indicator);
        String otherPart = sqlSplit[1].split("\\)")[1];

        String otherMaterial = otherPart + sqlSplit[2];
        String[] otherList = otherMaterial.split("\n");
        for (String s : otherList) {
            if (s.startsWith("COMMENT")) {
                tableComment = s.split(" ")[1];
            }
            if (s.startsWith("PARTITIONED BY")) {
                dimension = parseDimension(s);
            }
            if (s.startsWith("STORED AS")) {
                storeType = s.replace("STORED AS ", "");
            }
            if (s.startsWith("FIELDS TERMINATED BY")) {
                fields = s.replace("FIELDS TERMINATED BY ", "");
            }
            if (s.startsWith("LINES TERMINATED BY")) {
                lines = s.replace("LINES TERMINATED BY ", "");
            }
            if (s.startsWith("COLLECTION ITEMS TERMINATED BY")) {
                collection = s.replace("COLLECTION ITEMS TERMINATED BY ", "");
            }
            if (s.startsWith("MAP KEYS TERMINATED BY")) {
                mapKey = s.replace("MAP KEYS TERMINATED BY ", "");
            }
        }

        System.out.println("name: " + name);
        System.out.println("tableComment: " + tableComment);
        System.out.println("indicator: " + indicator);
        System.out.println("dimension: " + dimension);
        System.out.println("storeType: " + storeType);
        System.out.println("fields: " + fields);
        System.out.println("lines: " + lines);
        System.out.println("collection: " + collection);
        System.out.println("mapKey: " + mapKey);

    }

    private static String parseDimension(String dimension) {
        GeneratorSqlTest.Dimension dim = new GeneratorSqlTest.Dimension();
        dimension = dimension.replaceAll("PARTITIONED BY ", "").replace("COMMENT ", "").replace(")","");
        String[] dimList = dimension.split(",");

        for (String d : dimList) {
            String[] dList = d.split(" ");
            dim.setName(dList[0]);
            dim.setType(dList[1]);
            dim.setComment(dList[2].replace("\"",""));
            dim.setPartition(true);
        }
        return JSON.toJSONString(dim);
    }

    private static String parseIndicator(String indicator) {

        List<GeneratorSqlTest.Indicator> indicators = new ArrayList<>();
        // pt    bigint    COMMENT "日期分区"    ,hr    bigint    COMMENT "小时分区"    ,crt_trd_cnt_1d    bigint    COMMENT "最近一天下单交易数",
        String[] indicatorList = indicator.split(",");
        for (String i : indicatorList) {
            if (StringUtils.isNotBlank(i)) {
                GeneratorSqlTest.Indicator indicator1 = new GeneratorSqlTest.Indicator();
                i = i.replace("COMMENT", "").trim();

                Pattern p = Pattern.compile("\\s+");
                Matcher m = p.matcher(i);
                i= m.replaceAll(" ");

                String[] iList = i.split(" ");
                indicator1.setName(iList[0].trim());
                indicator1.setType(iList[1].trim());
                indicator1.setComment(iList[2].trim().replace("\"", ""));
                indicator1.setPartition(false);
                indicators.add(indicator1);
            }
        }

        return JSON.toJSONString(indicators);
    }


}
