class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> Long.compare(a.first, b.first));
        pq.add(new Tuple(0, 0));
        while(!pq.isEmpty()){
            long dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            for(Pair it: adj.get(node)){
                int adjNode = it.first;
                long adjW = it.second;
                if(dis + adjW < dist[adjNode]){
                    dist[adjNode] = dis + adjW;
                    pq.add(new Tuple(dis+adjW, adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(dis + adjW == dist[adjNode]){
                    ways[adjNode] = (int)((ways[adjNode] + (long)ways[node]) % mod);
                }
            }
        }
        return ways[n-1];
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
    long first;
    int second;
    public Tuple(long first, int second){
        this.first = first;
        this.second = second;
    }
}