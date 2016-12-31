package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/31.
 */
public class Question67 {

    public static void main(String[] args) {
        int threshold = 4;
        int rows = 4;
        int cols  = 4;
        int count = movingCount(4,4,4);
        System.out.println(count);
    }

    static  int movingCount(int threshold, int rows, int cols){

        boolean [] visited = new boolean[rows*cols];

        int movingCount = moviingCountCore(threshold,rows,cols,0,0,visited);

        return  movingCount;
    }

    private static int moviingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {

        int count = 0;

        if (check(threshold,rows,cols,row,col,visited)){
            visited[rows*row+col] = true;
            count = 1+moviingCountCore(threshold,rows,cols,row-1,col,visited)
                    +moviingCountCore(threshold,rows,cols,row,col-1,visited)
                    +moviingCountCore(threshold,rows,cols,row+1,col,visited)
                    +moviingCountCore(threshold,rows,cols,row,col+1,visited);
        }

        return  count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if( row >= 0 && row < rows && col >=0 && col <cols
                & (getDigitSum(col)+getDigitSum(row) < threshold)
                & !visited[rows*row+col] )
            return  true;
        return false;
    }

    static  int getDigitSum(int digit){

        int sum = 0;
        while (digit > 0){
            sum += (digit%10);
            digit/=10;
        }
        return  sum;
    }
}
