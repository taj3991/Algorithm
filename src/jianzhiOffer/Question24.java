package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/17.
 */
public class Question24 {


    public static void main(String[] args) {
        int[] numbers ={5,7,6,9,11,10,8};
        int [] numbers2 = {7,4,6,5};
        numbers = numbers2;
        boolean isPostorder = isPostorderTraversal(numbers,0,numbers.length-1);
        System.out.println(isPostorder);
    }


    static  boolean isPostorderTraversal(int [] numbers, int start,int end){
        if ( numbers == null || numbers.length ==0 || start > end) return  false;


        boolean isPostorder = true;

        int root = numbers[end];

        int left =  start-1;
        for(int i = start ; i < end; i++){
            if (numbers[i] < root)left++;
        }
        if ( left > start ) isPostorder = isPostorderTraversal(numbers,start,left);
        if (!isPostorder)return isPostorder;


        for(int i = left+1; i < end; i++){
            if (numbers[i] < root) return false;
        }

        if ( left+1 < end ) isPostorder = isPostorderTraversal(numbers,left,end-1);
        return isPostorder;

    }




}
