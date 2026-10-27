class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        boolean[][] vis = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        vis[0][0] = true;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int dis = q.peek().dist;
            q.remove();
            if(row == n-1 && col == n-1) return dis;
            int[] dr = {-1,-1,-1,0,0,1,1,1};
            int[] dc = {-1,0,1,-1,1,-1,0,1};
            for(int i=0; i<8; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && vis[nr][nc] == false){
                    q.add(new Pair(nr, nc, dis+1));
                    vis[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}
class Pair{
    int first;
    int second;
    int dist;
    Pair(int first, int second, int dist){
        this.first = first;
        this.second = second;
        this.dist = dist;
    }
}