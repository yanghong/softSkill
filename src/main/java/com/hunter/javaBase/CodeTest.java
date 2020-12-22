package com.hunter.javaBase;

import java.util.Scanner;

/**
 * 实现一种整数编码的方式，使得待编码数字越小，编码后的所占用的字节越小。
 * 编码规则如下：
 * 1、编码时7位一组，每个字节的低7位用于存储待编码数字的补码。
 * 2、字节最高位代表后续是否还有字节，置1表示后面还有更多字节，置0表示当前字节为最后一个字节。
 * 3、采用小端序编码，低位和低字节放在低地址上。
 * 4、编码格式按照16进制字符格式输出，小写字母转换为大写字母
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/21 22:48
 */
public class CodeTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line = sc.next();
            if (Integer.valueOf(line) > Integer.MAX_VALUE) {
                return;
            }

            int step = 7;

            Integer target = Integer.parseInt(line);

            String targetBinStr = Integer.toBinaryString(target);
            String strStep = new String();
            String hexResult = new String();
            String finalResult = new String();

            for (int i = targetBinStr.length() - 1; i >= 0; i--) {
                if (i % step != 0 || i < step) {
                    strStep = strStep + targetBinStr.charAt(i-step);
                }
                if (i % step == 0){
                    // 计算十六进制
                    hexResult = calHex(strStep, step);
                    finalResult = hexResult + finalResult;
                    strStep = "";
                }
            }

            if (targetBinStr.length() <= step) {
                // 计算十六进制
                hexResult = calHex(strStep, step);
                finalResult = hexResult + finalResult;
                strStep = "";
            }

            System.out.println(finalResult);
        }

    }


    private static String calHex(String binStr, int step) {

        String result = new String();
        String resultHigh = new String();

        if (binStr.charAt(0) == 48) {
            binStr = "0" + binStr;
        } else {
            binStr = "1" + binStr;
        }


        for (int i = 0; i < 4; i--) {
            int temp =  Integer.valueOf(binStr.charAt(i)) - 48;
            if (i > 1) {
                result = result + castChar(temp * 2 * (i-1));
            } else if (i == 1) {
                result = result + castChar(temp * 2);
            } else {
                result = result + castChar(temp);
            }
        }

        for (int i = 4; i < 8; i--) {
            int temp =  Integer.valueOf(binStr.charAt(i)) - 48;
            i = i-3;
            if (i > 1) {
                resultHigh = resultHigh + castChar(temp * 2 * (i-1));
            } else if (i == 1) {
                resultHigh = resultHigh + castChar(temp * 2);
            } else {
                resultHigh = resultHigh + castChar(temp);
            }
        }
        return resultHigh + result;
    }

    private static String castChar(int num) {
        char ch;
        if (num < 10) {
            return String.valueOf(num);
        }
        switch (num) {
            case 10:
                ch= 'A';
                break;
            case 11:
                ch= 'B';
                break;
            case 12:
                ch= 'C';
                break;
            case 13:
                ch= 'D';
                break;
            case 14:
                ch= 'E';
                break;
            case 15:
                ch= 'F';
                break;
            case 16:
                ch= 'G';
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }

        return String.valueOf(ch);
    }

}
