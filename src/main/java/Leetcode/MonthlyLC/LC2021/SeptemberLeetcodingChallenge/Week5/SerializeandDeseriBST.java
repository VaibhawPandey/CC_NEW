package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week5;

public class SerializeandDeseriBST {

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        String data = new SerializeandDeseriBST().serialize(root);
        root = new SerializeandDeseriBST().deserialize(data);
    }


    StringBuilder stringBuilder = new StringBuilder();
    public String serialize(TreeNode root) {

        if (root == null)
            return null;

        serializeUtil(root);
        return stringBuilder.toString();
    }

    public void serializeUtil(TreeNode root) {

        if (root == null) {
            stringBuilder.append((StringBuffer) null +",");
            return;
        }
        else
            stringBuilder.append(root.val +",");

        serializeUtil(root.left);
        serializeUtil(root.right);
    }

    // Decodes your encoded data to tree.
    int index;
    public TreeNode deserialize(String data) {

        String dataList[] = data.split(",");
        index = 0;
        return deserializeUtil(dataList);
    }

    private TreeNode deserializeUtil(String[] dataList) {

        if (dataList[index].equalsIgnoreCase("null"))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(dataList[index]));
        index++;
        node.left = deserializeUtil(dataList);
        index++;
        node.right = deserializeUtil(dataList);

        return node;
    }
}
