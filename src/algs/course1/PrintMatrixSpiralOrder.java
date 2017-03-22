package algs.course1;

/**
 * Created by lxh on 2017/3/22.
 */
public class PrintMatrixSpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix){
        int lR = 0, lC = 0, rR = matrix.length - 1, rC = matrix[0].length - 1;
        while (lR <= rR && lC <= rC){
            printEdge(matrix, lR++, lC++, rR--, rC--);
        }
    }

    public static void printEdge(int[][] matrix, int lR, int lC, int rR, int rC){
        if (lR > rR && lC > rC){
            return;
        }
        //只有一行
        if (lR == rR){
            while (lC <= rC){
                System.out.print(matrix[lR][lC++] + " ");
            }
            return;
        }
        //只有一列
        if (lC == rC){
            while (lR <= rR){
                System.out.print(matrix[lR++][lC]);
            }
            return;
        }
        //一般情况
        int curR = lR, curC = lC;
        while (curC != rC){
            System.out.print(matrix[curR][curC++] + " ");
        }
        while (curR != rR){
            System.out.print(matrix[curR++][curC] + " ");
        }
        while (curC != lC){
            System.out.print(matrix[curR][curC--] + " ");
        }
        while (curR != lR){
            System.out.print(matrix[curR--][curC] + " ");
        }
    }
}
