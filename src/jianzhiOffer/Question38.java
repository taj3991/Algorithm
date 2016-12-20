package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/20.
 */
public class Question38 {


    public static void main(String[] args) {
        int [] arr ={1,2,3,3,3,4,4,5,6,7,9};
        int count = getNumberOfK2(arr,4);
        System.out.println(count);
    }

    static int getNumberOfK(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while (arr[mid] != k) {
            if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start+end)/2;
        }
        int count = 0;
        int tempMid = mid;
        while (arr[mid] == k && mid >= 0) {
            mid--;
            count++;
        }
        tempMid = tempMid + 1;
        while (tempMid <= end && arr[tempMid] == k ) {
            tempMid++;
            count++;
        }

        return count;
    }


    static int getNumberOfK2(int[] arr, int k) {
        int firstKIndex  = getFirstOfK(arr,0,arr.length-1,k);
        int lastKIndex  = getLastOfK(arr,0,arr.length-1,k,arr.length);

        int count = 0;
        if (firstKIndex !=-1 && lastKIndex != -1){
            count = lastKIndex-firstKIndex+1;
        }
        return  count;
    }


    static  int getFirstOfK(int [] arr ,int start,int end,int k){
        if (start > end) return  -1;

        int mid =  (start+end)/2;
        int midData = arr[mid];

        if ( midData == k){
            if ( (mid > 0 && arr[mid-1] != k ) || mid == 0 ){
                return  mid;
            }else{
                end = mid-1;
            }
        }else if ( midData > k){
             end = mid -1;
        }else{
             start = mid+1;
        }
        return getFirstOfK(arr,start,end,k);
    }



    static  int getLastOfK(int [] arr ,int start,int end,int k,int len){
        if (start > end) return  -1;

        int mid =  (start+end)/2;
        int midData = arr[mid];

        if ( midData == k){
            if ( (mid < len-1 && arr[mid+1] != k ) || mid == len-1 ){
                return  mid;
            }else{
                start = mid+1;
            }
        }else if ( midData > k){
            end = mid -1;
        }else{
            start = mid+1;
        }
        return getLastOfK(arr,start,end,k,len);
    }




}
