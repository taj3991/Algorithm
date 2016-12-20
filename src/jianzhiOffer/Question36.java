package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/20.
 */
public class Question36 {

    public static void main(String[] args) {
        int [] arr ={7,5,6,6,4,5};
        int count = inversePairs(arr);
        System.out.println(count);
    }

    static int inversePairs(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("Input Error");
        int[] arrayCopy = new int[arr.length];
        System.arraycopy(arr,0,arrayCopy,0,arr.length);
        int count = inversePairsCore(arr, arrayCopy, 0, arr.length - 1);
        return count;
    }

    private static int inversePairsCore(int[] arr, int[] arrCopy, int start, int end) {
            if (start == end) return 0;
            int mid = (start + end) / 2;
            int left = inversePairsCore(arrCopy, arr, start, mid);
            int right = inversePairsCore(arrCopy, arr, mid + 1, end);

        int i = mid;
        int j = end;

        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= mid + 1) {
            if (arr[i] > arr[j]) {
                count += j - (mid + 1) + 1;
                arrCopy[indexCopy--] = arr[i--];
            } else {
                arrCopy[indexCopy--] = arr[j--];
            }
        }

        while (i >= start) {
            arrCopy[indexCopy--] = arr[i--];
        }
        while (j >= mid + 1) {
            arrCopy[indexCopy--] = arr[j--];
        }
        return left + right + count;
    }


}
