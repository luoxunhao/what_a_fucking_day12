package algs.array;

/**
 * Created by lxh on 2017/3/22.
 */
public class ZigZagPrintMatrix {

    public static void printDiag(int[][] matrix, int tr, int tc, int dr, int dc, boolean flag){
        if (flag){ //右上到左下
            while (tr != dr + 1){
                System.out.print(matrix[tr++][tc--] + " ");
            }
        }else { //左下到右上
            while (dr != tr - 1){
                System.out.print(matrix[dr--][dc++] + " ");
            }
        }
    }

    public static void zigZag(int[][] matrix){
        int tr = 0, tc = 0, dr = 0, dc = 0;
        int endR = matrix.length - 1, endC = matrix[0].length - 1;
        boolean flag = false;
        while (tr != endR + 1){
            printDiag(matrix, tr, tc, dr, dc, flag);
            tr = tc == endC ? tr + 1 : tr;
            tc = tc == endC ? endC : tc + 1;
            dc = dr == endR ? dc + 1 : dc;
            dr = dr == endR ? dr : dr + 1;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        zigZag(matrix);

    }
}
