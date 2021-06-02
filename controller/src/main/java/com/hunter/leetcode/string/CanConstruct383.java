package com.hunter.leetcode.string;

//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
//
//
//
// 示例 1：
//
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//
//
// 示例 2：
//
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//
//
// 示例 3：
//
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//
//
//
// 提示：
//
//
// 你可以假设两个字符串均只含有小写字母。
//
// Related Topics 字符串
// 👍 151 👎 0



/**
 * @author yanghong
 */
public class CanConstruct383 {

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (null == magazine || null == ransomNote) {
            return false;
        }

        boolean flag = false;

        for (int i = 0; i < ransomNote.length(); i++ ) {
            char a = ransomNote.charAt(i);
            String aStr = String.valueOf(a);
            if (magazine.contains(aStr)) {
                flag = true;
                magazine = magazine.replaceFirst(aStr, "");
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {

        //解答失败: 测试用例:"fihjjjjei" "hjibagacbhadfaefdjaeaebgi"

        String ransomNote = "fihjjjjei", magazine = "hjibagacbhadaefdjaeaebgi";

        System.out.println(canConstruct(ransomNote, magazine));

    }
}
