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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
          max = Integer.MIN_VALUE;
          diameter(root);
          return max-1;
    }

    int diameter(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = diameter(root.left);
        int right = diameter(root.right);

        max = Math.max(max,left+right+1);
        return Math.max(left,right)+1;
    }
}
