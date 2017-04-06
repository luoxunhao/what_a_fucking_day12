package algs.dfs;

/**
 * Created by lxh on 2017/4/6.
 */
public class PathInMatrix {
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i*rows+j] == str[0]){
                    boolean[] visit = new boolean[rows*cols];
                    if (dfs(matrix,rows,cols,str,visit,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[] matrix, int rows, int cols, char[] str, boolean[] visit, int cx, int cy, int pos){
        if (pos == str.length-1){
            for (int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && matrix[nx*cols + ny] == str[pos] && !visit[nx*cols + ny]){
                    return true;
                }
            }
            return false;
        }
        visit[cx*cols + cy] = true;
        for (int i = 0; i < 4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && matrix[nx*cols + ny] == str[pos+1] && !visit[nx*cols + ny]){
                if (dfs(matrix,rows,cols,str,visit,nx,ny,pos+1)){
                    return true;
                }
            }
        }
        return false;
    }
}
