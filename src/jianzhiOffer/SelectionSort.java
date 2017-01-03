package jianzhiOffer;

/**
 * Created by tangjian on 2017/1/3.
 */
public class SelectionSort {



    public static void main(String[] args) {
        int [] numbers ={3,1,4,9,2,7,0,-2};
        selectionSort(numbers);
        for(int i: numbers){
            System.out.print(i+"\t");
        }

    }


    static  void selectionSort(int [] numbers) {
        if (numbers == null || numbers.length < 1) return;

        int len = numbers.length;
        for(int i = 0 ; i < len-1; i++){
            int k = i;
            for(int j = i+1;j < len;j++){
                if (numbers[k] > numbers[j]){
                    k = j;
                }
            }
            if (k != i){
                swap(numbers,k,i);
            }
        }
    }


    static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
