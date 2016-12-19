package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/17.
 */
public class Question29 {


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 5};
        int num = findMoreThanHalfNumber2(arr);
        System.out.println(num);
    }


    static int findMoreThanHalfNumber2(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Input Error");
        }

        int middle = arr.length >> 1;
        int start = 0;
        int end = arr.length - 1;

        int index = partition(arr, start, end);

        while (middle != index) {
            if (index > middle) {
                end = index-1;
            } else {
                start = index+1;
            }
            index = partition(arr, start, end);
        }
        check(arr, arr[middle]);
        return arr[middle];
    }

    private static int partition(int[] arr, int start, int end) {
        swap(arr, start, end);

        int index = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                swap(arr, i, index++);
            }
        }
        swap(arr, index, end);
        return index;
    }

    static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static int findMoreThanHalfNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Input Error");
        }
        int result = arr[0];
        int times = 1;
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];

            if (times == 0) {
                result = num;
                times = 1;
            }

            if (num != result) {
                times--;
            }
        }

        check(arr, result);
        return result;

    }

    static void check(int[] arr, int num) {

        int times = 0;
        for (int i : arr) {
            if (num == i) times++;
        }

        if (times * 2 <= arr.length) {
            throw new RuntimeException("Input error");
        }

    }
}