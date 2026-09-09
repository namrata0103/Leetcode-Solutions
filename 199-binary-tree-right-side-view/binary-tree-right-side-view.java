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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, TreeNode> map = new TreeMap<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            map.put(p.level, p.node);
            if(p.node.left != null){
                q.offer(new Pair(p.node.left, p.level + 1));
            }
            if(p.node.right != null){
                q.offer(new Pair(p.node.right, p.level + 1));
            }
        }
        for(TreeNode curr: map.values()){
            ans.add(curr.val);
        }
        return ans;
    }
    class Pair{
        TreeNode node;
        int level;

        Pair(TreeNode n, int l){
            this.node = n;
            this.level = l;
        }
    }
}