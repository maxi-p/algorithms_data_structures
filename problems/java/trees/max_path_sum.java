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

// maxPath = max(maxLeft+maxRight+root.val,maxPath.left, maxPath.right)

class Solution 
{
    public int maxPath=(Integer.MIN_VALUE/100);
    
    public int maxPathSum(TreeNode root) 
    {
        // System.out.println(maxPath);
        maxHeight(root);

        return maxPath;
    }

    public int maxHeight(TreeNode root)
    {
        if (root == null)
            return (Integer.MIN_VALUE/100);
        
        int maxLeft     = maxHeight(root.left);
        int maxRight    = maxHeight(root.right);
        
        int maxHeight   = Math.max(maxLeft, maxRight);  
        maxHeight = Math.max(maxHeight+root.val, root.val);

        maxPath = Math.max(maxPath, maxLeft);
        maxPath = Math.max(maxPath, root.val);
        maxPath = Math.max(maxPath, maxRight);
        maxPath = Math.max(maxPath, root.val+maxLeft);
        maxPath = Math.max(maxPath, root.val+maxRight);
        maxPath = Math.max(maxPath, root.val+maxLeft+maxRight);
        

        return maxHeight;
    }


}
