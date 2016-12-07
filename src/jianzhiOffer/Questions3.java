package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/7.
 */
public class Questions3 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 8, 9};
        int[] arr2 = {2, 4, 9, 12};
        int[] arr3 = {4, 7, 10, 13};
        int[] arr4 = {6, 8, 11, 15};
        int[][] arr = {arr1, arr2, arr3, arr4};
        int num = 7;
        boolean find = findNumInTwoDimensionalArray2(arr, num);
        System.out.println(find);
    }

    static boolean findNumInTwoDimensionalArray(int[][] arr, int num) {
        if (arr == null || arr.length == 0) return false;
        boolean find = false;
        int row = 0;
        int col = 0;
        int curNum = arr[row][col];
        int arrCols = arr[0].length - 1;
        int arrRows = arr.length - 1;

        while (!find) {
            if (curNum == num) {
                System.out.println("row:" + row + ";col:" + col);
                return true;
            }
            if (curNum < num) {
                if (row == 0 && col < arrCols)
                    col++;
                else
                    row++;

            } else if (curNum > num) {
                if (row == 0) {
                    col--;
                    row++;
                } else {
                    col--;
                }
            }

            if (row < 0 || col < 0 || row > arrRows || col > arrCols) {
                System.out.println("row:" + row + ";col:" + col);
                return false;
            }
            curNum = arr[row][col];
        }

        return false;
    }


    static boolean findNumInTwoDimensionalArray2(int[][] arr, int num) {
        if (arr == null || arr.length == 0) return false;
        int row = 0;
        int col = arr[0].length - 1;

        int arrCols = arr[0].length - 1;
        int arrRows = arr.length - 1;

        while (row <= arrRows && col >=0 ) {
            int curNum = arr[row][col];
            if (curNum == num) {
                System.out.println("row:" + row + ";col:" + col);
                return true;
            }
            if (curNum > num) {
                    col--;

            } else {
                    row++;
            }

        }
        return false;
    }


}
