package com.hunter.leetcode;

// 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
// 1. set(string key, string value, int timestamp)
//
// 存储键 key、值 value，以及给定的时间戳 timestamp。
// 2. get(string key, int timestamp)
//
// 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
// 如果有多个这样的值，则返回对应最大的 timestamp_prev 的那个值。
// 如果没有值，则返回空字符串（""）。
//
// 示例 1：
//
// 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["f
//oo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
//输出：[null,null,"bar","bar",null,"bar2","bar2"]
//解释:
//TimeMap kv;
//kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
//kv.get("foo", 1);  // 输出 "bar"
//kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即
// "bar"）
//kv.set("foo", "bar2", 4);
//kv.get("foo", 4); // 输出 "bar2"
//kv.get("foo", 5); // 输出 "bar2"
//
// 示例 2：
//
// 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [
//[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["lov
//e",20],["love",25]]
//输出：[null,null,null,"","high","high","low","low"]
//
// 提示：
//
// 所有的键/值字符串都是小写的。
// 所有的键/值字符串长度都在 [1, 100] 范围内。
// 所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。
// 1 <= timestamp <= 10^7
// TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。
//
// Related Topics 设计 哈希表 字符串 二分查找
// 👍 117 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanghong
 */
public class TimeMap981 {

    class Pair implements Comparable<Pair> {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return timestamp + value.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair pair2 = (Pair) obj;
                return this.timestamp == pair2.timestamp && this.value.equals(pair2.value);
            }
            return false;
        }

        @Override
        public int compareTo(Pair pair2) {
            if (this.timestamp != pair2.timestamp) {
                return this.timestamp - pair2.timestamp;
            } else {
                return this.value.compareTo(pair2.value);
            }
        }
    }

    Map<String, List<Pair>> map;

    public void TimeMap() {
        map = new HashMap<String, List<Pair>>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<Pair>());
        pairs.add(new Pair(timestamp, value));
        map.put(key, pairs);
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<Pair>());
        // 使用一个大于所有 value 的字符串，以确保在 pairs 中含有 timestamp 的情况下也返回大于 timestamp 的位置
        Pair pair = new Pair(timestamp, String.valueOf((char) 127));
        int i = binarySearch(pairs, pair);
        if (i > 0) {
            return pairs.get(i - 1).value;
        }
        return "";
    }

    private int binarySearch(List<Pair> pairs, Pair target) {
        int low = 0, high = pairs.size() - 1;
        if (high < 0 || pairs.get(high).compareTo(target) <= 0) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            Pair pair = pairs.get(mid);
            if (pair.compareTo(target) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {

    }
}
