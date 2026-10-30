class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;
        pq.add(new Tuple(0, k));
        while(!pq.isEmpty()){
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            for(Pair it: adj.get(node)){
                int adjNode = it.first;
                int adjW = it.second;
                if(dis + adjW < dist[adjNode]){
                    dist[adjNode] = dis + adjW;
                    pq.add(new Tuple(dis+adjW, adjNode));
                }
            }
        }
        int ans = 0;
        for(int i=1; i<dist.length; i++){
            if(dist[i] == (int)1e9) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
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
class Tuple{
    int first;
    int second;
    public Tuple(int first, int second){
        this.first = first;
        this.second = second;
    }
}