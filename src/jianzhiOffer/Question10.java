package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/11.
 */
public class Question10 {


    public static void main(String[] args) {

        int count = NumberOf1Count_Good(7);
        System.out.println(count);
    }


    static int NumberOf1Count_Stuipd(int n) {

        int count = 0;
        while (n != 0) {
            if (n % 2 == 1 || n % 2 == -1)
                count++;
            n = n >>> 1;
        }
        return count;
    }


    static int NumberOf1Count_Good(int n) {
        int count = 0;
        int num = 1;
        while (n != 0) {
            int temp = num & n;
            if (temp != 0)
                count++;
            num = num << 1;
            if (num > n) break;
        }
        return count;
    }


    static int NumberOf1Count_Perfect(int n) {

        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }


    public static void main2(String[] args) {
        int a = 129;
        int b = 128;
        System.out.println("a 和b 或的结果是：" + (a | b));
    }

}
