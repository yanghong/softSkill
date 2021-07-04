package com.hunter.BizTest.sql.analysis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yanghong
 */
public class AfterAnalysisData {

    public static void main(String[] args) throws IOException {
        String prefix = "/Users/yanghong/IdeaProjects/softSkill/controller/src/main/java/com/hunter/BizTest/sql/analysis/";

        File file = new File(prefix + "allSqlMap.txt");
        String allSqlMapString = FileUtils.readFileToString(file);

        // 分析所有数据 all Sql Map
        Map<String, Set<String>> allSqlMap = JSONObject.parseObject(allSqlMapString, new TypeReference<Map<String, Set<String>>>(){});

        // 分析目标数据 target Sql Set Map
        File targetSqlSetMapFile = new File(prefix + "targetSqlSetMap.txt");
        String targetSqlSetMapString = FileUtils.readFileToString(targetSqlSetMapFile);
        Map<String, Set<String>> targetSqlSetMap = JSONObject.parseObject(targetSqlSetMapString, new TypeReference<Map<String, Set<String>>>(){});

        for (Map.Entry<String, Set<String>> entry : targetSqlSetMap.entrySet()) {
            Set<String> targetSet = allSqlMap.get(entry.getKey());
            if (null == targetSet) {
                System.out.println("empty set: " + entry.getKey());
            }
        }

        // 分析最终答案数据
        File remainFile = new File(prefix + "remain.txt");
        String remainString = FileUtils.readFileToString(remainFile);
        List<String> remainList = Arrays.asList(remainString.split("\n"));

        System.out.println("allSqlMap size :" + allSqlMap.size());
        System.out.println("tar size:" + targetSqlSetMap.size());
        System.out.println("remain size:" + remainList.size());
    }
}
