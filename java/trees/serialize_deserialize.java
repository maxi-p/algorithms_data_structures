/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        String res = "";
        res = dfs(root, res);

        return res;
    }

    public String dfs(TreeNode root, String res)
    {
        if (root == null)
        {
            res += "N,";
            return res;
        }

        res += (root.val+",");

        res = dfs(root.left, res);
        res = dfs(root.right, res);

        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data.charAt(0) == 'N')
            return null;

        TreeNode node = new TreeNode();
        dfs(data, 0, node);

        return node;
    }

    public int dfs(String data, int index, TreeNode node)
    {
        if (index >= data.length())
        {
            return index;
        }

        else
        {
            int num = 0;
            String curNum = "";
            while(data.charAt(index) != ',')
            {
                curNum += data.charAt(index);
                index ++;
            }

            num = Integer.parseInt(curNum);
            node.val = num;
            index++;
            
            curNum = "";
            int i = index;
            while(data.charAt(i) != ',')
            {
                curNum += data.charAt(i);
                i++;
            }
            if(!curNum.equals("N"))
            {
                node.left = new TreeNode();
                index = dfs(data, index, node.left);
            }
            else
            {
                node.left = null;
                index = i+1;
            }

            curNum = "";
            i = index;
            while(data.charAt(i) != ',')
            {
                curNum += data.charAt(i);
                i++;
            }
            if(!curNum.equals("N"))
            {
                node.right = new TreeNode();
                index = dfs(data, index, node.right);
            }
            else
            {
                node.right = null;
                index = i+1;
            }
        }

        return index;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
