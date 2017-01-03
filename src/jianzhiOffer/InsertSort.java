package jianzhiOffer;

/**
 * Created by tangjian on 2017/1/3.
 */
public class InsertSort {

    public static void main(String[] args) {
        int [] numbers ={3,1,4,9,2,7,0,-2,12,2};
        insertSort(numbers);
        for(int i: numbers){
            System.out.print(i+"\t");
        }
    }


    static void insertSort(int[] numbers) {
        if (numbers == null || numbers.length < 1) return;
        int len = numbers.length;
        for (int i = 1; i < len; i++) {
          insertSortCore(numbers,0,i);
        }
    }

    static void insertSortCore(int [] numbers,int start,int end){
        int index = start;
        int num = numbers[end];
        for (; index < end; index++){
            if (num < numbers[index])break;
        }
        for (int i = end-1 ; i >= index; i--){
            numbers[i+1] = numbers[i];
        }
        numbers[index] = num;
    }
}
