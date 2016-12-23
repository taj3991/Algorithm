package jianzhiOffer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tangjian on 2016/12/23.
 */
public class Question43 {

    public static void main(String[] args) {

     /*   Integer [] arr = {0,1,2,3,4};
      leftNumber(Arrays.asList(arr),3);*/

        System.out.println(-2%4);
    }

    static  void leftNumber(List<Integer> integerListst,int n){

        int count = 0;
        int index = 0;
        int removeNumer = 0;
        while(removeNumer != integerListst.size() -1){
            if (index == integerListst.size()){
                index = 0;
            }
            if(integerListst.get(index) != -1){
                count++;
                if (count % n == 0){
                    System.out.println("remove number:"+integerListst.get(index));
                    integerListst.set(index,-1);
                    removeNumer++;
                }
                index++;
            }else{
                index++;
            }
        }

        for (int i:integerListst){
            if ( i != -1){
                System.out.println(i);
            }
        }

    }
}
