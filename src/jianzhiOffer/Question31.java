package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/19.
 */
public class Question31 {

    public static void main(String[] args) {

        int [] numbers ={-2,2,-1,10,-34,20,-5,6};
        int maxSum =dynamicSolveMethod(numbers);
                //maxSubArraySum(numbers);
        System.out.println(maxSum);
    }
    static  int maxSubArraySum(int [] numbers) {
        if ( numbers == null || numbers.length == 0 )
            throw  new RuntimeException("Input Error");

        int maxSum = numbers[0];
        int sum = numbers[0];

        for ( int i = 1 ; i < numbers.length; i++){
            sum += numbers[i];
            if (sum > maxSum) maxSum = sum;
            else if ( sum < 0 ) sum = 0;
        }
        return  maxSum;
    }



    static  int  dynamicSolveMethod(int [] arr){
        if ( arr == null || arr.length == 0 )
            throw  new RuntimeException("Input Error");

        int curMaxSum = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            int maxSumEndWithI = fn(arr,i);
            if (maxSumEndWithI > curMaxSum) curMaxSum = maxSumEndWithI;
        }
        return curMaxSum;
    }

     static  int fn(int [] arr,int i){
         if ( i == 0 || fn(arr,i-1) < 0)return arr[i];
         return  fn(arr,i-1)+arr[i];
     }

}
