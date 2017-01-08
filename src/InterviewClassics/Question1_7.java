package InterviewClassics;

/**
 * Created by tangjian on 2017/1/8.
 */
public class Question1_7 {


    public static void main(String[] args) {


        int [][] mat ={{0,2,3},{4,5,6},{7,8,9}};
        setZeros(mat,3);
        for(int [] arr:mat){
            for(int i:arr){
                System.out.print(i+"\t");
            }
            System.out.println();
        }

    }


    static void setZeros(int[][] mat,int n){
        boolean rows[] = new boolean[n];
        boolean cols[] = new boolean[n];

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if (mat[i][j] == 0 ){
                    rows[i] = true;
                    cols[j] = true;
                }
            }

        }
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if (rows[i] || cols[j] ){
                    mat[i][j] =0;
                }
            }

        }

    }


}
