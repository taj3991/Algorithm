package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjian on 2016/12/31.
 */
public class Question65 {


    public static void main(String[] args) {

     int [] arr = {2,3,4,2,6,2,5,1};
      LinkedList<Integer> linkedList = maxWindows(arr,3);

        for(int i : linkedList){
            System.out.print(i+"\t");
        }

    }

    static LinkedList maxWindows(int [] arr,int size){
        if (arr == null || arr.length < size) return  null;

        LinkedList<Integer> indexList = new LinkedList();
        for( int i = 0 ; i < size ; i++){
            while( !indexList.isEmpty() && arr[i] > arr[indexList.getLast()] ){
              indexList.removeLast();
            }
            indexList.addLast(i);
        }

        LinkedList<Integer> maxWindowList = new LinkedList<>();
        for ( int i = size ; i < arr.length ; i ++){
            maxWindowList.addLast(arr[indexList.getFirst()]);

            while( !indexList.isEmpty() && arr[i] > arr[indexList.getLast()] ){
                indexList.removeLast();
            }
            if (!indexList.isEmpty() && (indexList.getFirst()<= i-size ) ){
                indexList.pop();
            }
            indexList.addLast(i);
        }

        maxWindowList.addLast(arr[indexList.getFirst()]);
        return  maxWindowList;

    }



}
