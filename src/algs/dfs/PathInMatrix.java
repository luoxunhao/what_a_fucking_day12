package algs.dfs;

/**
 * Created by lxh on 2017/4/6.
 */
public class PathInMatrix {
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean[] visit = new boolean[rows*cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                //if (matrix[i*rows+j] == str[0]){
                    //boolean[] visit = new boolean[rows*cols];
                    if (dfs(matrix,rows,cols,str,visit,i,j,0)){
                        return true;
                    }
                //}
            }
        }
        return false;
    }
    public static boolean dfs(char[] matrix, int rows, int cols, char[] str, boolean[] visit, int cx, int cy, int pos){
        if (pos == str.length){
            return true;
        }
        if (cx < 0 || cx >= rows || cy < 0 || cy >= cols){
            return false;
        }
        if (!visit[cx*cols + cy] && matrix[cx*cols + cy] == str[pos]) {
            visit[cx * cols + cy] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (dfs(matrix, rows, cols, str, visit, nx, ny, pos + 1)) {
                    return true;
                }
            }
            visit[cx * cols + cy] = false;
        }
        return false;
    }
}
