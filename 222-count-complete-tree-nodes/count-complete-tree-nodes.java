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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = heightLeft(root);
        int rh = heightRight(root);
        if(lh == rh){
            return ((1 << lh) - 1);
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    public static int heightLeft(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + heightLeft(root.left);
    }
    public static int heightRight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + heightRight(root.right);
    }
}