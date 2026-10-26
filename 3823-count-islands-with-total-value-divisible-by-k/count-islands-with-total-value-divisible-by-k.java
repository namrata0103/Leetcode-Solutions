class Solution {
    int ans;
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j] != 0){
                    bfs(grid, k, vis, i, j);
                }
            }
        }
        return ans;
    }
    public void bfs(int[][] grid, int k, boolean[][] vis, int i, int j){
        Queue<Pair> q = new LinkedList<>();
        long sum = 0;
        q.add(new Pair(i, j));
        vis[i][j] = true;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            sum += grid[row][col];
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            for(int d=0; d<4; d++){
                int nr = row + dr[d];
                int nc = col + dc[d];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && vis[nr][nc] == false && grid[nr][nc] != 0){
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }
        if(sum % k == 0) ans++;
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