package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/31.
 */
public class Question66 {


    public static void main(String[] args) {

        char[] matrix = {
                'a', 'b', 'c', 'e',
                's', 'f', 'c', 's',
                'a', 'd', 'e', 'e'
        };
        boolean hasPath = hasPath(matrix, 3, 4, "bccees".toCharArray());
        System.out.println(hasPath);
    }

    static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) return false;
        boolean[] visited = new boolean[cols * rows];
        int[] pathLength = {0};

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int[] pathLength, boolean[] visited) {
        if (pathLength[0] >= str.length) return true;

        boolean hasPath = false;

        if (row >= 0 && row < rows && col >= 0 && col < cols &&
                matrix[row * cols + col] == str[pathLength[0]] && !visited[row * cols + col]) {
            pathLength[0] += 1;
            visited[row * cols + col] = true;

            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited);

            if (!hasPath) {
                pathLength[0] -= 1;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;

    }


}
