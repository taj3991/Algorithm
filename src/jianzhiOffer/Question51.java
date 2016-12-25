package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/25.
 */
public class Question51 {


    public static void main(String[] args) {
        int [] arr ={6,3,1,0,2,5,3};
        int repeatNumber = findRepeatNumber(arr);
        System.out.println(repeatNumber);
    }

    static int findRepeatNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new RuntimeException("Input Error :");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr.length) return -1;
        }

        int repeatNumber = -1;
        for (int i = 0; i < arr.length; i++) {

            if (repeatNumber != -1){
                return  repeatNumber;
            }
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    repeatNumber = arr[i];
                    break;
                }
                swap(arr, arr[i], i);
            }
        }
        return repeatNumber;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
