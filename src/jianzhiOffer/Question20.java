package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/15.
 */
public class Question20 {


    static  void printMatrixClockwisely(int [][] numbers,int columns,int rows){

        if ( numbers == null || columns <=0 || rows <= 0){
            return;
        }

        int start = 0;

        while(rows > start*2 && columns > start*2){

            printMatrixInCircle(numbers,columns,rows,start);



            start++;
        }



    }

    private static void printMatrixInCircle(int[][] numbers, int columns, int rows,int start) {

        int endX = columns - 1- start;
        int endY = rows -1 - start;

        for(int i = start ; i <= endX; i ++ ){
            int num = numbers[start][i];
            System.out.println(num);
        }

        if (endY > start){
            for(int i = start+1 ; i <= endY; i ++ ){
                int num = numbers[i][endX];
                System.out.println(num);
            }
        }

        if(endY > start && endX >start){
            for(int i = endX-1 ; i >= start; i -- ){
                int num = numbers[endX][i];
                System.out.println(num);
            }
        }


        if(endX > start && endY-1 >start){
            for(int i = endY-1 ; i > start; i -- ){
                int num = numbers[i][start];
                System.out.println(num);
            }
        }









    }


}
