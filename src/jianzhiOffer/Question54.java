package jianzhiOffer;

import java.util.regex.Pattern;

/**
 * Created by tangjian on 2016/12/28.
 */
public class Question54 {

    public static void main(String[] args) {

        String str ="322.12e-12";
        boolean isNumber = isNumber(str);
        System.out.println(isNumber);
    }

    /**
     * 分为2部分：
     * 第1部分不含e:  1.1 整数 。正整数和负整数 1.2 小数  正数小数和负数小数
     * 第2部分含e: 1.1整数 。正整数和负整数 1.2 小数  正数小数和负数小数
     * @param str
     * @return
     */
    static boolean isNumber(String str) {
        String[] regexs = {"[+-]?\\d+[.]?\\d+", "[+-]?\\d+(.\\d+)?[e|E][+-]?\\d+"};

        boolean isNumber = false;
        for (String regex : regexs) {
            isNumber = Pattern.compile(regex).matcher(str).matches();
            if (isNumber)break;
        }

        return isNumber;


    }

}
