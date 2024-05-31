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
class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<TreeNode>      q   = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        q.add(root);

        while(q.size()!=0)
        {
            List<Integer> curInt   = new ArrayList<>();
            int len = q.size();
            for(int i=0; i<len; i++)
            {
                TreeNode cur = q.remove(0);
                curInt.add(cur.val);
                
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            res.add(curInt);
        }
        return res;
    }
}
