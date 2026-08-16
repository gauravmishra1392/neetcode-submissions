// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  * int val;
//  * TreeNode left;
//  * TreeNode right;
//  * TreeNode() {}
//  * TreeNode(int val) { this.val = val; }
//  * TreeNode(int val, TreeNode left, TreeNode right) {
//  * this.val = val;
//  * this.left = left;
//  * this.right = right;
//  * }
//  * }
//  */
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         int[] result = new int[2]; // [num,pos]
//         traverse(root, k, result);
//         return result[0];
//     }

//     private void traverse(TreeNode node, int k, int[] result) {
//         if (node.left != null)
//             traverse(node.left, k, result);

//         if (result[1] == k)
//             return;

//         result[1] = result[1] + 1;

//         if (result[1] == k) {
//             result[0] = node.val;
//             return;
//         }
//         if (node.right != null)
//             traverse(node.right, k, result);
//     }
// }

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
    public int kthSmallest(TreeNode root, int k) {
        int arr[] = new int[1];
        int arr2[] = new int[1];
        findMin(root,k,arr,arr2); 
        return arr[0];
    }

    void findMin(TreeNode root,int k, int arr[],int arr2[]){
    
        if(root == null){
            return;
        }
        findMin(root.left,k,arr,arr2);
        arr2[0]++;
        if(arr2[0] == k){
             arr[0] = root.val;
        }
        findMin(root.right,k,arr,arr2);
    }
}
