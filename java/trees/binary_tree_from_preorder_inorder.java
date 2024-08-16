/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private HashMap<Integer, Integer> hash;
    private int[] gPreorder;
    private int[] gInorder;
    private int len;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        len = preorder.length;
        if (len == 0) {
            return null;
        }
        hash = new HashMap<>();
        gPreorder = preorder;
        gInorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i], i);
        }

        return buildTreeUtil(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTreeUtil(int start, int end, int startInorder, int endInorder){
        TreeNode head = new TreeNode(gPreorder[start]);

        if (start == end)
            return head;

        int index = hash.get(head.val);

        int leftStart = start + 1;
        int leftEnd = start + (index - startInorder);
        int rightStart = leftEnd + 1;
        int rightEnd = end;

        if (index != startInorder)
            head.left = buildTreeUtil(leftStart, leftEnd, startInorder, index - 1);
        
        if (index != endInorder)
            head.right = buildTreeUtil(rightStart, rightEnd, index + 1, endInorder);

        return head;
    }
}
