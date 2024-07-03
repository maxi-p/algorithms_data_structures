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
    public boolean isValidBST(TreeNode root) 
    {
        return isValidBSTUtil(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean isValidBSTUtil(TreeNode root, long high, long low)
    {
        if (root == null)
        {
            return true;
        }

        if (root.val > high || root.val < low)
        {
            return false;
        }

        return (root.left == null || (root.left.val < root.val && root.left.val > low)) 
        && (root.right == null || (root.right.val > root.val && root.right.val < high)) 
        && isValidBSTUtil(root.left, root.val, low) && isValidBSTUtil(root.right, high, root.val);
    }
}
