class Solution {
    public int minCost(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int n = grid.length;
        int m = grid[0].length; 
        Set<Integer>[][] vis = new HashSet[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                vis[i][j] = new HashSet<>();
            }
        }
        Queue<Pair> q = new LinkedList<>();
        vis[0][0].add(grid[0][0]);
        q.add(new Pair(grid[0][0], 0, 0));
        while(!q.isEmpty()){
            int minXor = q.peek().first;
            int row = q.peek().second;
            int col = q.peek().third;
            q.remove();
            if(row == n-1 && col == m-1){
                ans = Math.min(ans, minXor);
                continue;
            }
            int[] dr = {1, 0};
            int[] dc = {0, 1};
            for(int k=0; k<2; k++){
                int nr = row + dr[k];
                int nc = col + dc[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int newMinXor = minXor ^ grid[nr][nc];
                    if(!vis[nr][nc].contains(newMinXor)){
                        q.add(new Pair(newMinXor, nr, nc));
                        vis[nr][nc].add(newMinXor);
                    }
                }
            }
        }
        return ans;
    }
}
class Pair{
    int first;
    int second;
    int third;
    public Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}