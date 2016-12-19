package jianzhiOffer;

import java.util.*;
import java.util.jar.Pack200;

/**
 * Created by tangjian on 2016/12/18.
 */
public class Question30 {


    public static void main(String[] args) {


        int [] arr = {4,5,1,6,2,7,3,8,0};
        int [] result = getLeatKNumbersUseMaxHeap(arr,4);
       for (int i:result){
           System.out.println(i);
       }
    }

    static  int[] getLeatKNumbers( int [] arr,int k){
        if ( arr == null || arr.length == 0 )
            throw  new RuntimeException("Input Error");

        int start  = 0;
        int end = arr.length -1;
        int index = partition(arr,start,end);

        while (index != k-1){
            if ( index < k-1){

                start = index +1;
                System.out.println("start: "+start);
            }else{
                end = index -1;
                System.out.println("end : "+end);
            }

            index = partition(arr,start,end);
        }


        int[] output = new int[k];
        for( int i = 0 ; i < k ; i++ ){
            output[i] = arr[i];
        }
        return  output;
    }




    private static int partition(int[] arr, int start, int end) {
        if (start > end){
            throw  new RuntimeException("Start index must no gt end index in arr");
        }
        swap(arr, start, end);

        int index = start-1;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                index ++;
                swap(arr, i, index);
            }
        }
        index++;
        swap(arr, index, end);
        return index;
    }

    static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }





    static  int[] getLeatKNumbersUseMaxHeap( int [] arr,int k) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("Input Error");
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i:arr){

            if (treeMap.size() < k){
                treeMap.put(i,i);
            }else{
                int key = treeMap.lastKey();
                if (i < key) {
                    treeMap.pollLastEntry();
                    treeMap.put(i,i);
                }
            }
        }
        int[] output = new int[k];
        int i = 0;
       for(Iterator<Map.Entry<Integer,Integer>> it = treeMap.entrySet().iterator(); it.hasNext();){
           output[i++] = it.next().getKey();
       }
        return  output;
    }

}
