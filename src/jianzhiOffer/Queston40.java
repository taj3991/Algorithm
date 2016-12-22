package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/22.
 */
public class Queston40 {


    public static void main(String[] args) {

        int [] numbers = {1,2,2,3,3,4,4,12,1,9,9,7,7,112};
        int [] result = findAppearOnceNumber(numbers);
        for(int i:result){
            System.out.println(i);
        }
    }



    static  int[] findAppearOnceNumber(int [] numbers){
        if ( numbers == null || numbers.length == 0)return  null;

        int a = 0;
        for(int i :numbers){
            a = a ^ i;
        }
        int bit1Postion = findFirstBitIs1(a);

        int x = 0;
        int y = 0;

        for ( int i: numbers){
            if (isBit1(i,bit1Postion)){
                x ^=i;
            }else{
                y ^=i;
            }
        }
        int [] result = {x,y};
        return  result;
    }


    static  boolean isBit1(int i,int bit1Position){
        bit1Position = bit1Position-1;
        return ((i >> bit1Position)& 1 ) == 0;
    }

    static  int findFirstBitIs1( int i ){
        int num = 0;
        while( i > 0){
            num ++;
            if ( (i&1)  == 1)break;
            i = i >>1;
        }
        return  num;
    }


}
