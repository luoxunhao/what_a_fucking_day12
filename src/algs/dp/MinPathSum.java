package algs.dp;

/**
 * 矩阵的最小路径和
 */
public class MinPathSum {
    public static int minPathSum1(int[][] m){
        if (m == null || m.length <= 0 || m[0] == null || m[0].length <= 0){
            return 0;
        }
        int row = m.length, col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        //dp矩阵的第一行
        for (int i = 1; i < col; i++){
            dp[0][i] = dp[0][i-1] + m[0][i];
        }
        //dp矩阵的第一列
        for (int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] + m[i][0];
        }
        //dp[i][j]
        for (int i = 1; i < col; i++){
            for (int j = 1; j <row; j++){
                dp[i][j] = m[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[row - 1][col - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    // for test
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[][] m = generateRandomMatrix(3, 4);
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 },
                { 8, 8, 4, 0 } };
        printMatrix(m);
        System.out.println(minPathSum1(m));
        //System.out.println(minPathSum2(m));
    }
}
