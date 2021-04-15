package main.java.Leetcode.MonthlyLC.JulyLeetcodingChallenge.Week4;

public class BTInorderPostOrder {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        TreeNode root = null;
        idx = inorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1, null);
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end, TreeNode root) {

        if (start < end || idx < 0)
            return null;

        root = new TreeNode(postorder[idx--]);

        int position = getPositionInInorderList(inorder, root.val);

        root.right = build(inorder, postorder, position + 1, end, root);
        root.left = build(inorder, postorder, start, position - 1, root);

        return root;
    }

    private int getPositionInInorderList(int[] inorder, int val) {

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val)
                return i;
        }

        return -1;
    }
}
