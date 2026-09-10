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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
    public int[] helper(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        int[] lh = helper(root.left);
        int[] rh = helper(root.right);

        int sum = root.val + lh[0] + rh[0];
        int cnt = 1 + lh[1] + rh[1];
        int avg = sum/cnt;
        if(avg == root.val){
            ans++;
        }
        return new int[]{sum, cnt};
    }
}