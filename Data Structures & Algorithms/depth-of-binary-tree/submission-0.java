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
    int max = 0;
    public int maxDepth(TreeNode root) {
    maxL(root,0); 
     return max;
    }

    void maxL(TreeNode node, int length){
        if(node == null){
            max = Math.max(max,length);
            return;
        }

        maxL(node.left,length+1);
        maxL(node.right,length+1);
    }
}
