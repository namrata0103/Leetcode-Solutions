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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        inOrder(root, in);
        return in;
    }
    public static void inOrder(TreeNode root, List<Integer> in){
        if(root == null) return;
        inOrder(root.left, in);
        in.add(root.val);
        inOrder(root.right, in);
    }
}