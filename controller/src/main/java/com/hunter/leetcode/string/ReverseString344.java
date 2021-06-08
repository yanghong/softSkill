package com.hunter.leetcode.string;

//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
//
//
//
// 示例 1：
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
//
//
// 示例 2：
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"]
// Related Topics 双指针 字符串
// 👍 413 👎 0

/**
 * @author yanghong
 */
public class ReverseString344 {

    public static void reverseString(char[] s) {

        if (s.length < 2) {
            return;
        }

        int mid = s.length / 2;

        for (int i = 0; i < mid; i++) {
            int j = s.length - 1 - i;
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {

        // char[] s = {'H','a','n','n','a','h'};
        // ["A"," ","m","a","n",","," ","a"," ","p","l","a","n",","," ","a"," ","c","a","n","a","l",":"," ","P","a","n","a","m","a"]
// 测试结果:["a","m","a","n","a","P"," ",":","l","a","n","a","c"," "," ","a",",","n","a","l","p"," ","a"," ",",","n","a","m"," ","A"]
// 期望结果:["a","m","a","n","a","P"," ",":","l","a","n","a","c"," ","a"," ",",","n","a","l","p"," ","a"," ",",","n","a","m"," ","A"]
        char[] s = {'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
       reverseString(s);

    }
}
