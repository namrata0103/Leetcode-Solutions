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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        int width = 0;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().index;
            int first = 0, last = 0;
            for(int i=0; i<size; i++){
                int currInd = q.peek().index - min;
                TreeNode temp = q.peek().node;
                q.poll();
                if(i == 0){
                    first = currInd;
                }
                if(i == size - 1){
                    last = currInd;
                }
                if(temp.left != null){
                    q.add(new Pair(temp.left, 2 * currInd + 1));
                }
                if(temp.right != null){
                    q.add(new Pair(temp.right, 2 * currInd + 2));
                }
            }
            width = Math.max(width, last - first + 1);
        }
        return width;
    }
    class Pair{
        TreeNode node;
        int index;

        Pair(TreeNode n, int i){
            this.node = n;
            this.index = i;
        }
    }
}