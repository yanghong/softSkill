package com.hunter.BizTest;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
            System.out.println(i);
            indicator = indicator + i;
        }

        String otherMaterial = indicatorSpilt[1];
        String[] otherList = otherMaterial.split("\n");
        for (String s : otherList) {
            if (s.startsWith("COMMENT")) {
                tableComment = s.split(" ")[1];
            }
            if (s.startsWith("PARTITIONED BY")) {
                dimension = s;
            }
            if (s.startsWith("STORED AS")) {
                storeType = s.replace("STORED AS", "");
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


}
