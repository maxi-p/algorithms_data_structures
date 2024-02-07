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
    public TreeNode invertTree(TreeNode root) {
        invertUtil(root);
        // qSolution(root);
        return root;
    }

    public void invertUtil(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }

        else{
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertUtil(root.left);
            invertUtil(root.right);
        }
    }

    public void qSolution(TreeNode root){
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);

        while(q.size() != 0){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.remove(0);
                if(cur != null){
                    q.add(cur.left);
                    q.add(cur.right);

                    System.out.println("Q rocks!!");
                    TreeNode temp = cur.left;
                    cur.left = cur.right;
                    cur.right = temp;
                }
            }
        }
    }
}