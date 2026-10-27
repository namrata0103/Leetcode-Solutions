class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
        boolean[][] vis = new boolean[n][m];
        pq.add(new Pair(0, 0, 0));
        while(!pq.isEmpty()){
            int effort = pq.peek().first;
            int row = pq.peek().second;
            int col = pq.peek().third;
            pq.remove();
            if(vis[row][col]) continue;
            vis[row][col] = true;
            if(row == n-1 && col == m-1){
                return effort;
            }
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, 1, -1};
            for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == false){
                    int diff = Math.abs(heights[nr][nc] - heights[row][col]);
                    int newEffort = Math.max(effort, diff);
                    pq.add(new Pair(newEffort, nr, nc));
                }
            }
        }
        return -1;
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