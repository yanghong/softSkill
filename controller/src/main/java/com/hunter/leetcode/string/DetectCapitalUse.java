package com.hunter.leetcode.string;

// 给定一个单词，你需要判断单词的大写使用是否正确。
//
// 我们定义，在以下情况时，单词的大写用法是正确的：
//
// 全部字母都是大写，比如"USA"。
// 单词中所有字母都不是大写，比如"leetcode"。
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
//
// 否则，我们定义这个单词没有正确使用大写字母。
//
// 示例 1:
//
//
//输入: "USA"
//输出: True
//
//
// 示例 2:
//
//
//输入: "FlaG"
//输出: False
//
//
// 注意: 输入是由大写和小写拉丁字母组成的非空单词。
// Related Topics 字符串
// 👍 133 👎 0


/**
 * @author yanghong
 */
public class DetectCapitalUse {

    public static boolean detectCapitalUse(String word) {

        if (null == word) {
            return false;
        }

        if (word.toUpperCase().equals(word)) {
            return true;
        }

        char w = String.valueOf(word.charAt(0)).toUpperCase().charAt(0);
        if (w == word.charAt(0)) {
            // 判断下面还有没有大写
            for (int i = 1; i < word.length(); i++) {
                if (upperChar(word.charAt(i))) {
                    return false;
                }
            }
        } else {

            for (int i = 0; i < word.length(); i++) {
                if (upperChar(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean upperChar(char w) {
        return String.valueOf(w).toUpperCase().charAt(0) == w;
    }

    public static void main(String[] args) {
        String word = "USA";
        System.out.println(detectCapitalUse(word));
    }
}
