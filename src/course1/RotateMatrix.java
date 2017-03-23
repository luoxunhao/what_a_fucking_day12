package course1;

/**
 * Created by lxh on 2017/3/22.
 */
public class RotateMatrix {  // N x N

    public static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC){
        int times = dC - tC; //需要调整的组数
        for (int i = 0; i < times;  i++){
            int tmp = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = matrix[tR][tC + i];
            matrix[tR][tC + i] = tmp;
        }
    }

    public static void rotateMatrix(int[][] matrix){
        int tR = 0, tC = 0, dR = matrix.length - 1, dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC){
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
