package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjian on 2016/12/17.
 */
public class Question28 {


    public static void main(String[] args) {

        String str = "abc";
        char[] arr = str.toCharArray();
        perm2(arr);

       /* List indexList = new ArrayList();

        List charList = new ArrayList();


        for (int i = 0; i < arr.length; i++) {
            indexList.add(i);
            charList.add(arr[i]);
            permutation(arr, arr.length, indexList, charList);

            indexList.clear();
            charList.clear();

        }*/
    }

    static void permutation(char[] arr, int len, List indexList, List charList) {
        for (int i = 0; i < len; i++) {
            if (indexList.contains(i)) continue;
            indexList.add(i);
            charList.add(arr[i]);
            if (charList.size() == len) {
                System.out.println(charList.toString());
            } else {
                permutation(arr, len, indexList, charList);
            }
            indexList.remove(indexList.size() - 1);
            charList.remove(charList.size() - 1);
        }


    }


    static void perm2(char[] arr) {

        if (arr == null) return;

        perm2(arr, 0);


    }

    private static void perm2(char[] arr, int start) {
        if ( start == arr.length -1) {
            System.out.println(arr);
        } else {
            for (int j = start; j < arr.length; j++) {
                swap(start, j, arr);
                perm2(arr,start+1);
                swap(j,start, arr);
            }
        }
    }


    static void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
