package com.hunter.string;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class YarnApplicationInfoParseTest {

    public static void main(String[] args) {
        String json = "{\n" +
                "\t\"scheduler\": {\n" +
                "\t\t\"schedulerInfo\": {\n" +
                "\t\t\t\"type\": \"fairScheduler\",\n" +
                "\t\t\t\"rootQueue\": {\n" +
                "\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\"memory\": 674816,\n" +
                "\t\t\t\t\t\"vCores\": 245\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\"memory\": 674816,\n" +
                "\t\t\t\t\t\"vCores\": 245\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\"allocatedContainers\": 97,\n" +
                "\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\"queueName\": \"root\",\n" +
                "\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\"childQueues\": {\n" +
                "\t\t\t\t\t\"queue\": [{\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 1024000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 200\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 2048000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 400\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 1024000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 200\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.elves\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 4096000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 800\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 4096000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 800\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.app\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 10,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 102400,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 20\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 204800,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 40\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 102400,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 20\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.stream\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 10,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 409600,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 200\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 409600,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 200\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 409600,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 200\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.devops\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 2048000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 400\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 4096000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 800\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 2048000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 400\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.ad\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 7133184,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 1741\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 7133184,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 1741\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.bi\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 4096000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 800\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 4096000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 800\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.iq\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 10000,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 8138000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 2133\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 8138000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 2133\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 8138000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 2133\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.dp\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 1024000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 200\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 2048000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 400\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 1024000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 200\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.risk\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 7133184,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 1741\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 7133184,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 1741\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.alg\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"childQueues\": {\n" +
                "\t\t\t\t\t\t\t\"queue\": [{\n" +
                "\t\t\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 713318,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 174\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"queueName\": \"root.alg.low\",\n" +
                "\t\t\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 3566592,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 871\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"queueName\": \"root.alg.high\",\n" +
                "\t\t\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 2853274,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 696\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"queueName\": \"root.alg.normal\",\n" +
                "\t\t\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 4096000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 800\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 8192000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 1600\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 4096000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 800\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.default\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 50,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 4096000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 600\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 6144000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 800\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 4096000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 600\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.search\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 15036579,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3876\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 12288,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 4\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 12288,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 4\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 15036579,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3876\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 15036579,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3876\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 4,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.dw\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"childQueues\": {\n" +
                "\t\t\t\t\t\t\t\"queue\": [{\n" +
                "\t\t\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 15036579,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3876\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 15036579,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3876\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"queueName\": \"root.dw.core\",\n" +
                "\t\t\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 15036579,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3876\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 15036579,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3876\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"allocatedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"queueName\": \"root.dw.high\",\n" +
                "\t\t\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"numActiveApps\": 0\n" +
                "\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 15036579,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3876\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 12288,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 4\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 12288,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 4\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 15036579,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3876\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 15036579,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3876\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"allocatedContainers\": 4,\n" +
                "\t\t\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"queueName\": \"root.dw.normal\",\n" +
                "\t\t\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"numActiveApps\": 2\n" +
                "\t\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"type\": \"fairSchedulerLeafQueueInfo\",\n" +
                "\t\t\t\t\t\t\"maxApps\": 2147483647,\n" +
                "\t\t\t\t\t\t\"minResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 2048000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 400\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"maxResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 4096000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 800\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"usedResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 662528,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 241\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demandResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 662528,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 241\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"steadyFairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 2048000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 400\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"fairResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 2048000,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 400\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"clusterResources\": {\n" +
                "\t\t\t\t\t\t\t\"memory\": 11796480,\n" +
                "\t\t\t\t\t\t\t\"vCores\": 3040\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"pendingContainers\": 0,\n" +
                "\t\t\t\t\t\t\"allocatedContainers\": 93,\n" +
                "\t\t\t\t\t\t\"reservedContainers\": 0,\n" +
                "\t\t\t\t\t\t\"queueName\": \"root.production\",\n" +
                "\t\t\t\t\t\t\"schedulingPolicy\": \"DRF\",\n" +
                "\t\t\t\t\t\t\"numPendingApps\": 0,\n" +
                "\t\t\t\t\t\t\"numActiveApps\": 5\n" +
                "\t\t\t\t\t}]\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

//        JSONArray queueArray = JSONObject.parseObject(json).
//                getJSONObject("scheduler").
//                getJSONObject("schedulerInfo").
//                getJSONObject("rootQueue").
//                getJSONObject("childQueues").
//                getJSONArray("queue");
//        for (int i = 0; i < queueArray.size(); i++) {
//            JSONObject queue = queueArray.getJSONObject(i);
//            String queueName = queue.getString("queueName");
//            if (null != queueName) {
//                JSONObject usedResources = queue.getJSONObject("usedResources");
//                System.out.println(usedResources.getLong("memory"));
//                System.out.println(usedResources.getLong("vCores"));
//            }
//        }

        JSONObject jsonObject = JSONObject.parseObject("{\n" +
                "  \"beans\" : [ ]\n" +
                "}");

        JSONArray jsonArray = jsonObject.getJSONArray("beans");

        System.out.println(jsonObject);
    }
}
