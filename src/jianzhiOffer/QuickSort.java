package jianzhiOffer;

import java.util.Random;

/**
 * Created by tangjian on 2016/12/8.
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = { 17,14};
        quickSort(0, arr.length - 1, arr);
        for (int i : arr) {
            System.out.println(i);
        }


    }


    static void quickSort(int start, int end, int[] arr) {
       if (start >= end || arr == null)return;

        int index = partition2(start, end, arr);
        if (index > start) {
            quickSort(start, index - 1, arr);
        }
        if (index < end)
            quickSort(index + 1, end, arr);

    }

    static int partition(int start, int end, int[] arr) {
        int randomIndex = start;
        swap(randomIndex, end, arr);

        int left = start-1;
        for (; start < end; start++) {
            if (arr[start] < arr[end]) {
                left++;

                if (left != start)
                    swap(left, start, arr);
            }
        }
        left++;
        swap(left, end, arr);
        return left;
    }


    static int partition2(int start, int end, int[] arr) {
        int randomIndex = start;
        swap(randomIndex, end, arr);

        int left = start;
        int right = end - 1;

        for (; right >=  left ; start++) {
            if (arr[start] < arr[end]) {
                arr[left++] = arr[start];
            } else {
                while (arr[right] >= arr[end] && right > left) right--;
                if ( right == left ) break;

                swap(start, right--, arr);
                left++;
            }
        }
        swap(left, end, arr);
        return left;
    }

    static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
