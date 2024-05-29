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
    public int maxDepth(TreeNode root) 
    {
        if ( root == null )
            return 0; 

        if ( root.left == null && root.right == null )
            return 1;
        
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        
        // if ( root == null )
        // {
        //     return 0;
        // }

        // List<TreeNode>  queue   = new ArrayList<>();
        // int             lvl     = 0;
        // queue.add(root);
        
        // while ( queue.size() != 0 )
        // {
        //     int size = queue.size();
        //     for (int i=0; i<size; i++)
        //     {
        //         TreeNode cur = queue.remove(0);

        //         // left
        //         if ( cur.left != null )
        //         {
        //             queue.add(cur.left);
        //         }

        //         // right
        //         if ( cur.right != null )
        //         {
        //             queue.add(cur.right);
        //         }
        //     }
        //     lvl++;
        // }
        // return lvl;
    }
}
