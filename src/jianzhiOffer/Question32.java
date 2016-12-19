package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/19.
 */
public class Question32 {


    public static void main(String[] args) {
        int num = numberOf1ByViewNumberLaw(41);
        System.out.println(num);
    }

    static int numberof1Between1AndN(int n) {
        if (n < 1) return -1;
        int num = 0;
        for (int i = 1; i < n; i++) {
            num += numberOf1(i);
        }
        return num;
    }


    static int numberOf1(int n) {
        int num = 0;
        while (n > 0) {
            if ( n % 10 == 1) num++;
            n = n / 10;
        }
        return  num;
    }



    static  int numberOf1ByViewNumberLaw(int n){
        if ( n <= 0)return  0;
        if ( n == 1) return  1;

        //1出现在最高为的情况
         int num1InFirstDigit = 0;
         int firstNum = getFirstNum(n);

         int numLength = (n+"").length();
        if (firstNum > 1){
           num1InFirstDigit = (int)Math.pow(10,numLength-1);
        }else{
            num1InFirstDigit = n - (int)Math.pow(10,numLength-1)+1;
        }

        //除了第一位之外的数目
        int numOtherDigits = firstNum*(numLength-1)*(int)Math.pow(10,numLength-2);



        int lowLeveNum = n % (int)Math.pow(10,numLength-1);
        int numRecursive = getFirstNum(lowLeveNum);

        return  num1InFirstDigit+numOtherDigits + lowLeveNum;
    }




    static  int getFirstNum(int n){
        int firstNum  = n;
        while( n > 10){
            firstNum = n = n/10;
         }
          return  firstNum;
    }


}
