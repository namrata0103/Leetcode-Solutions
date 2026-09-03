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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> pos = new ArrayList<>();
        postOrder(root, pos);
        return pos;
    }
    public static void postOrder(TreeNode root, List<Integer> pos){
        if(root == null) return;
        postOrder(root.left, pos);
        postOrder(root.right, pos);
        pos.add(root.val);
    }
}