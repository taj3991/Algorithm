package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/22.
 */
public class Question41 {


    public static void main(String[] args) {

       /* int [] numbers ={1,2,4,7,9,11,15};
        int [] arr = findOnePairNumberEqN(numbers,13);


        for(int i:arr){
            System.out.println(i);
        }*/


       int count  = findEqNSequence(9);
        System.out.println(count);
    }


    static  int[] findOnePairNumberEqN(int [] numbers,int n){
        if ( numbers == null || numbers.length <= 1)return  null;

        int start = 0;
        int end = numbers.length-1;

        int low = (start+end)/2;
        int  high = low+1;
        int sum =numbers[low]+numbers[high];
        while( sum != n && high <= end && low >= start){
            if (sum < n){
                high = high+1;
            }else{
                low = low -1;
            }
            sum =numbers[low]+numbers[high];
        }
        if (sum != n) return  null;

        return new int[]{numbers[low],numbers[high]};
    }



    static  int question2(){


        return  0;
    }

    static  int findEqNSequence(int n){
        if (n < 0)return  -1;
        int endNumber = (n+1)/2;

        int sum = endNumber;
        int startNumber  = endNumber;
        int count = 0;
        while(startNumber > 0){
            startNumber --;
             if(sum < n){
              sum += startNumber;
            }else{
                if (sum == n) count++;

                sum = 0;
                endNumber = endNumber-1;
                sum += endNumber;
                startNumber = endNumber;
            }
        }

       return count;

    }





}
