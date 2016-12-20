package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/20.
 */
public class Question34 {

    public static void main(String[] args) {
        long i = getNthUglyNumber_Smart(1500);
        System.out.println(i);
    }


    static long getNthUglyNumber_Smart(int n) {

        int[] uglyNumberArray = new int[n];
        uglyNumberArray[0] = 1;
        int nextUglyNumberIndex = 1;

        int multiplyNumber2Number = 0;
        int multiplyNumber3Number = 0;
        int multiplyNumber5Number = 0;

        while (nextUglyNumberIndex < n) {
            int min = min(2 * uglyNumberArray[multiplyNumber2Number], 3 * uglyNumberArray[multiplyNumber3Number], 5 * uglyNumberArray[multiplyNumber5Number]);
            uglyNumberArray[nextUglyNumberIndex] = min;

            while (2 * uglyNumberArray[multiplyNumber2Number] <= uglyNumberArray[nextUglyNumberIndex]) {
                multiplyNumber2Number++;
            }

            while (3 * uglyNumberArray[multiplyNumber3Number] <= uglyNumberArray[nextUglyNumberIndex]) {
                multiplyNumber3Number++;
            }

            while (5 * uglyNumberArray[multiplyNumber5Number] <= uglyNumberArray[nextUglyNumberIndex]) {
                multiplyNumber5Number++;
            }

            nextUglyNumberIndex++;
        }

        return uglyNumberArray[n - 1];

    }

    private static int min(int i, int j, int k) {
        int min = i < j ? i : j;
        min = min < k ? min : k;
        return min;
    }


    static long getNthUglyNumber_Stupid(int n) {
        int count = 0;
        long uglyNumber = 0;
        for (long i = 1; i <= Long.MAX_VALUE; i++) {

            boolean result = isUglyNumber(i);
            if (result) {
                count++;
                uglyNumber = i;
                System.out.println(i);
                if (count >= n) break;
            }
        }
        return uglyNumber;
    }


    private static boolean isUglyNumber(long i) {
        while (i % 2 == 0) {
            i = i / 2;
        }
        while (i % 3 == 0) {
            i = i / 3;
        }

        while (i % 5 == 0) {
            i = i / 3;
        }
        return i == 1;
    }


}
