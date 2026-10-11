class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(bfs(i, color, graph) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean bfs(int i, int[] color, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int adj: graph[node]){
                if(color[adj] == -1){
                    color[adj] = 1 - color[node];
                    q.add(adj);
                }
                else if(color[adj] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}