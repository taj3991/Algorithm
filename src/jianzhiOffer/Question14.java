package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/13.
 */
public class Question14 {


    public static void main(String[] args) {
        int[] arr ={1,2,3,4,-5,6,7,-8};
         reorderOddEven3(arr);
        for(int i: arr){
            System.out.println(i);
        }
    }
    static void reorderOddEven(int [] arr){
       if ( arr == null )return;
        int oddIndex = 0;
        for(int i = 0 ; i < arr.length; i++){
            if ( (arr [i]&1) == 1 ){
                swap(arr,oddIndex,i);
                oddIndex ++;
            }
        }
    }


    static int[] reorderOddEven2(int [] arr){
        if ( arr == null )return null;
        int[] newArr = new int[arr.length];
        int oddIndex = 0;
        int evenIndex = 0;
        for(int i = 0 ; i < arr.length; i++){
            if ( (arr [i]&1) == 1 ){
                newArr[oddIndex] = arr[i];
                oddIndex ++;
            }else{
               newArr[arr.length-1-evenIndex] = arr[i];
                evenIndex ++;
            }
        }

        return  newArr;
    }


    static void reorderOddEven3(int [] arr){
        if ( arr == null || arr.length ==1 )return;

        int p1 = 0;
        int p2 = arr.length-1;

        while( p1 < p2){
            while(fun(arr,p1) && p1 < p2)p1++;
            while(!fun(arr,p2) && p2 > p1)p2--;
            swap(arr,p1,p2);
            p1 ++;
            p2 --;
        }
    }



    static boolean fun(int [] arr,int i){
        return arr[i] <= 0;
    }



    static  void swap(int [] arr ,int i , int j){
        if ( i == j) return;
        int temp =arr[i];
        arr[i] = arr[j];
        arr [j] = temp;
    }

}
