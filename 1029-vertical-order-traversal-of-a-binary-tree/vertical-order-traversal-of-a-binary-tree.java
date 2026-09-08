/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();
        q.offer(new Pair(root, 0, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode temp = p.node;
            int x = p.vertical;
            int y = p.level;
            if(!nodes.containsKey(x)){
                nodes.put(x, new TreeMap<>());
            }
            if(!nodes.get(x).containsKey(y)){
                nodes.get(x).put(y, new PriorityQueue<>());
            }
            nodes.get(x).get(y).offer(temp.val);
            if(temp.left != null){
                q.offer(new Pair(temp.left, x-1, y+1));
            }
            if(temp.right != null){
                q.offer(new Pair(temp.right, x+1, y+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> levels: nodes.values()){
            List<Integer> result = new ArrayList<>();
            for(PriorityQueue<Integer> pq: levels.values()){
                while(!pq.isEmpty()){
                    result.add(pq.poll());
                }
            }
            ans.add(result);
        }
        return ans;
    }
    class Pair{
        TreeNode node;
        int vertical;
        int level;

        Pair(TreeNode n, int v, int l){
            node = n;
            vertical = v;
            level = l;
        }
    }
}