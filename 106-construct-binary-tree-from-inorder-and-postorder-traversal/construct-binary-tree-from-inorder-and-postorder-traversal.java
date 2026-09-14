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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length-1, postorder, postorder.length-1, 0, inMap);
    }
    public static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer>inMap){
        if(inStart > inEnd || postStart < postEnd) return null;

        TreeNode root = new TreeNode(postorder[postStart]);
        int inRoot = inMap.get(root.val);
        int numsRight = inEnd - inRoot;

        root.right = build(inorder, inRoot+1, inEnd, postorder, postStart-1, postStart-numsRight, inMap);
        root.left = build(inorder, inStart, inRoot-1, postorder, postStart-numsRight-1, postEnd, inMap);

        return root;
    }
}