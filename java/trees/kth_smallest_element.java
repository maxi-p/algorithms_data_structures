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
    public int global = 0;
    public int kthSmallest(TreeNode root, int k) {
        kthUtil(root, k);
        return global;
    }

    public int kthUtil(TreeNode root, int k){
    	if (root == null)	return k;
    	k = kthUtil(root.left, k);
        if (k == 1) global = root.val;
        return kthUtil(root.right, k-1);
    }

}
