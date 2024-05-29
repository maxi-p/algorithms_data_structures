/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);   
        return root;

        // HashMap<Integer, Integer>   parent  = new HashMap<>();
        // HashMap<Integer, TreeNode>  node    = new HashMap<>();
        // traverse(root, parent, node);

        // HashSet<Integer> pathP = new HashSet<>();
        // int a = p.val;

        // while(a != root.val)
        // {
        //     pathP.add(a);
        //     a = parent.get(a);
        // }
        // pathP.add(a);
        // a = q.val;

        // while(a != root.val)
        // {
        //     if(pathP.contains(a))
        //         return node.get(a);
        //     a = parent.get(a);            
        // }

        // return root;
    }
    
    // public void traverse(TreeNode root, HashMap<Integer, Integer> parent, HashMap<Integer, TreeNode> node)
    // {
    //     if (root == null)
    //         return;

    //     if (root.left != null)
    //     {
    //         parent.put(root.left.val, root.val);
    //     }

    //     if (root.right != null)
    //     {
    //         parent.put(root.right.val, root.val);
    //     }

    //     node.put(root.val, root);
    //     traverse(root.left, parent, node);
    //     traverse(root.right, parent, node);
    // }
}
