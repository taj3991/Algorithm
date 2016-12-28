package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/28.
 */
public class Question52 {

    public static void main(String[] args) {

        int [] arr1 = {1,2,3,4};
        int [] arr2 = new int[arr1.length];
       buildMultiArray(arr1,arr2);
        for(int i: arr2){
            System.out.println(i);
        }
    }


    static int[] buildMultiArray(int [] array1,int[] array2){

        int len1 = array1.length;
        int len2 = array2.length;
        if (len1 != len2 || len1 <= 1){
            return null;
        }
        array2[0] = 1;

        for(int i = 1 ; i < len1 ; i++){
            array2[i] = array2[i-1]*array1[i-1];
        }

        int temp =1;
        for(int i = len1-2;i >= 0; i-- ){
            temp *= array1[i+1];
            array2[i] *=temp;
        }

        return  array2;
    }
}
