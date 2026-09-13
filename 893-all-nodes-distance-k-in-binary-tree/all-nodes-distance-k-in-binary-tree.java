/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                parent.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        q.add(target);
        visited.put(target, true);
        int dist = 0;
        while(!q.isEmpty()){
            if(dist == k) break;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null && !visited.containsKey(node.left)){
                    visited.put(node.left, true);
                    q.add(node.left);
                }
                if(node.right != null && !visited.containsKey(node.right)){
                    visited.put(node.right, true);
                    q.add(node.right);
                }
                if(parent.containsKey(node) && !visited.containsKey(parent.get(node))){
                    visited.put(parent.get(node), true);
                    q.add(parent.get(node));
                }
            }
            dist++;
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}