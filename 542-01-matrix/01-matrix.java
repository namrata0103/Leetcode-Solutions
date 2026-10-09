class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int st = q.peek().state;
            dis[row][col] = st;
            q.remove();
            for(int k=0; k<4; k++){
                int nr = row + dr[k];
                int nc = col + dc[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0){
                    q.add(new Pair(nr, nc, st+1));
                    vis[nr][nc] = 1;
                }
            }
        }
        return dis;
    }
}
class Pair{
    int first;
    int second;
    int state;
    public Pair(int first, int second, int state){
        this.first = first;
        this.second = second;
        this.state = state;
    }
}