class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        bfs(grid, vis, i, j, n, m);
                    }
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && vis[i][j] != 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void bfs(int[][] grid, int[][] vis, int i, int j, int n, int m){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = 1;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            for(int k=0; k<4; k++){
                int nr = row + dr[k];
                int nc = col + dc[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] != 1 && grid[nr][nc] == 1){
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = 1;
                }
            }
        }
    }
    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}