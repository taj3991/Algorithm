package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/20.
 */
public class MergeSort {

    public static void main(String[] args) {

      /*  int [] numbers ={0,1,7,2,9};
        numbers = mergeAdjoiningArray(numbers,0,2,4);
        for(int i:numbers){
            System.out.println(i);
        }*/

        int [] numbers ={12,0,1,7,2,9,-2};
        mergeSort(numbers,0,numbers.length-1);
        for(int i:numbers){
            System.out.println(i);
        }
    }





    static  void mergeSort(int [] numbers,int low ,int high){
        if ( numbers == null || numbers.length == 0 )
            throw  new RuntimeException("Input Error");
        int mid = (low+high)/2;

        if (low < high){
            System.out.println("low:"+low+";mid:"+mid);
            mergeSort(numbers,low,mid);
            System.out.println("mid+1:"+mid+1+";high:"+high);
            mergeSort(numbers,mid+1,high);

            mergeAdjoiningArray(numbers,low,mid,high);
        }
    }



    static  void mergeAdjoiningArray(int [] numbers,int low,int mid,int high){
        if ( numbers == null  || !( low<=mid && mid<high)) return ;

        int i = low;
        int j = mid+1;

        int[] tempArray = new int[high-low+1];
        int index = 0;
        while( i <=  mid && j <= high){
            if (numbers[i] < numbers[j]){
                tempArray[index++] = numbers[i];
                i ++;
            }else{
                tempArray[index++] = numbers[j];
                j ++;
            }
        }
        while( i <= mid){
            tempArray[index++] = numbers[i];
            i ++;
        }

        while( j <= high){
            tempArray[index++] = numbers[j];
            j ++;
        }

        System.arraycopy(tempArray,0,numbers,low,tempArray.length);
    }
}
