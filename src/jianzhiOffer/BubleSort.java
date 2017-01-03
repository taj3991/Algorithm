package jianzhiOffer;

import static jianzhiOffer.Question30.swap;

/**
 * Created by tangjian on 2017/1/3.
 */
public class BubleSort {


    public static void main(String[] args) {
        int [] numbers ={3,1,4,9,2,7,0,-2,11};
        bubleSort(numbers);
        for(int i: numbers){
            System.out.print(i+"\t");
        }

    }
    static  void bubleSort(int [] numbers){
        if (numbers == null || numbers.length < 1)return;
        int len = numbers.length;
        for(int i = 0 ; i < len-1 ; i++){
            for (int j = 0 ; j < len-i-1; j++){
                if (numbers[j] > numbers[j+1]){
                    swap(numbers,j,j+1);
                }
            }
        }
    }
}
