package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/25.
 */
public class Question47 {


    public static void main(String[] args) {

        int a = 2;
        int b = 3;

        int sum = sum(a,b);
        System.out.println(sum);
    }


    static int sum(int a , int b){
        int carry = 0;
        int sum = 0;
        do{
            sum = a^b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while(carry != 0);

        return  sum;

    }
}
