package InterviewClassics;

/**
 * Created by tangjian on 2017/1/7.
 *
 * 感觉这道题根本就不是旋转90度 ，根据给出来的示例来看只是矩阵的行列互换，
 然后代码放进去果然通过了。

 如果是顺时针旋转 
 1 2 3     7 4 1 
 4 5 6 =>8 5 2 
 7 8 9     9 6 3 
 逆时针旋转 
 1 2 3      9 6 3 
 4 5 6  =>8 5 2 
 7 8 9      7 4 1

 */
public class Question1_6 {



    public static void main(String[] args) {
        int [][] mat ={{1,2,3},{4,5,6},{7,8,9}};
        for(int [] arr:mat){
            for(int i:arr){
                System.out.print(i+"\t");
            }
            System.out.println();
        }

        System.out.println("=============");
        mat =   transformImage(mat,3);

        for(int [] arr:mat){
            for(int i:arr){
                System.out.print(i+"\t");
            }
            System.out.println();
        }

        String str = "            ";
        System.out.println('\u00A0');
        System.out.println(12131);
    }

    static void tranformImage(int[][] mat, int n) {
        int i, j, t;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
    }


/*    static void tranformImage2(int[][] mat, int n) {
        int i, j, t;
        for (i = 0; i < n; i++) {
            for (j = n - 1; j > i; j--) {
                t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }

    }
    }*/


  public  static  int[][] transformImage(int[][] mat, int n) {
        // write code here
        int[][] a = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                a[j][n - i - 1] = mat[i][j];
            }
        }
        return a;
    }
}

