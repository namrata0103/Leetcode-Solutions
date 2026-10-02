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
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        pushLeft(root, st1);
        pushRight(root, st2);

        TreeNode left = next(st1);
        TreeNode right = before(st2);

        while(left != null && right != null && left != right){
            int sum = left.val + right.val;
            if(sum == k) return true;
            else if(sum < k){
                left = next(st1);
            }
            else{
                right = before(st2);
            }
        }
        return false;
    }
    public static TreeNode next(Stack<TreeNode> st){
        TreeNode node = st.pop();
        pushLeft(node.right, st);
        return node;
    }
    public static TreeNode before(Stack<TreeNode> st){
        TreeNode node = st.pop();
        pushRight(node.left, st);
        return node;
    }
    public static void pushLeft(TreeNode root, Stack<TreeNode> st){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    public static void pushRight(TreeNode root, Stack<TreeNode> st){
        while(root != null){
            st.push(root);
            root = root.right;
        }
    }
}