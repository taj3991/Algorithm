package jianzhiOffer;

import java.util.LongSummaryStatistics;

/**
 * Created by tangjian on 2016/12/11.
 */
public class Question11 {

    public static void main(String[] args) {
        //double result = power(0.0d, 0);
        System.out.println((Integer.MAX_VALUE+"").length());

    }


    static double power(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            throw new RuntimeException("Base can not be 0 when exponet is a negative number");
        }

        boolean division = false;
        if (exponent < 0) {
            exponent = exponent * -1;
            division = true;
        }

        double result = 1.0d;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        if (division) result = 1 / result;
        return result;
    }


}
