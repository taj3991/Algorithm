package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/11.
 */
public class Question12 {

    public static void main(String[] args) {
        //System.out.println((int)'0');
        print1ToMaxOfDigits2(2);
    }

    static void print1ToMaxOfDigits(int n){
        if (n <=0)return;

        char [] chars = new char[n];
        for(int i = 0 ; i < n ; i ++){
            chars[i] = '0';
        }

        for (int i = 48 ; i <= 57 ; i ++){
            chars[0] = (char)i;
            print1ToMaxOfDigitsRecursively(chars,0,n);
        }


    }

    static  void print1ToMaxOfDigitsRecursively(char[] chars,int index,int n){

        if (index == n-1){
            printDigit(chars);
            return;
        }

        for(int i = 48 ; i <= 57 ; i ++){
            chars[index+1] = (char)i;
            print1ToMaxOfDigitsRecursively(chars,index+1,n);
        }

    }

    private static void printDigit(char[] chars) {

        boolean is0Beginning  = true;

        for(int i = 0 ; i <= chars.length-1 ; i ++){

            if (is0Beginning && chars[i]!='0'){
                is0Beginning =false;
            }

            if (!is0Beginning){
                System.out.print(chars[i]);
            }
        }

        System.out.print('\t');

    }




    static void print1ToMaxOfDigits2(int n){
        if (n <=0)return;

        char [] chars = new char[n];
        for(int i = 0 ; i < n ; i ++){
            chars[i] = '0';
        }

         while (!increment(chars)){

             printDigit(chars);
         }


    }

    private static boolean increment(char[] chars) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int len  = chars.length;
        for (int i = len-1; i >= 0;i -- ){

            int nSum = chars[i]-'0'+nTakeOver;
            if ( i == len -1) nSum ++;

            if ( nSum >= 10){
                if (i == 0){
                    isOverflow  = true;
                }else{

                    nSum -= 10;
                    nTakeOver = 1;
                    chars[i]= (char)(48+nSum);

                }
            }else{
                 chars[i] = (char)(48+nSum);
                  break;
            }


        }

        return isOverflow;
    }

}
