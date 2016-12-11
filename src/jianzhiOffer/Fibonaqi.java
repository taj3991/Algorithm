package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/11.
 */
public class Fibonaqi {


    public static void main(String[] args) {
        long result = fibonaqiSmart(5);
        System.out.println(result);
    }

    static int fibonaqiStuip(int n){
        int [] arr ={0,1};
        if ( n < 2){
            return arr[n];
        }

        return fibonaqiStuip(n-1) + fibonaqiStuip(n-2);

    }

    static long fibonaqiSmart(int n){

        int [] arr ={0,1};
        if ( n < 2){
            return arr[n];
        }

        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;

        for ( int i = 2 ; i <= n; i++){
            fibN = fibNMinusOne + fibNMinusTwo;
             fibNMinusTwo = fibNMinusOne;
             fibNMinusOne = fibN;
        }

        return  fibN;
    }







}
