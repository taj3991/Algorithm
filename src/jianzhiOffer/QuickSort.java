package jianzhiOffer;

import java.util.Random;

/**
 * Created by tangjian on 2016/12/8.
 */
public class QuickSort {




    static  void quickSort(int [] arr){
        if (arr == null)return;

    }

    static  void partition(int start,int end,int[] arr){
        if (start == end || arr == null)return;
        Random random = new Random();
        int randomValue= random.nextInt(end-start);
        int randomIndex  = start + randomValue;
        int compareValue = arr[randomIndex];
        swap(randomIndex,end,arr);

        int left=0;
        int right = end-1;
        for(int i = start; left < right; i++){
            if (arr[start] < compareValue){
                arr[left++] = arr[i];
            }else{
                    while (arr[right--] >= compareValue);
                    swap(i,right--,arr);
            }
        }
        swap(right,end,arr);
    }

    static  void swap(int i,int j,int [] arr){
        int tmp = arr[i];
        arr [i] = arr[j];
        arr [j] = tmp;
    }
}
