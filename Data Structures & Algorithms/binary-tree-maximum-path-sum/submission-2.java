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
    public int maxPathSum(TreeNode root) {
        int arr[]= new int[1];
          arr[0] = Integer.MIN_VALUE;
        maxPathSum(root,arr);
        return arr[0];
    }

    int maxPathSum(TreeNode root,int arr[]){
        if(root == null){
            return 0;
        }
        int leftMax =Math.max(0,  maxPathSum(root.left,arr));
        int rightMax =Math.max(0,  maxPathSum(root.right,arr));
        int sum = root.val+leftMax+rightMax;
        arr[0] = Math.max(arr[0],sum);
        return root.val + Math.max(leftMax,rightMax);
    }
}
