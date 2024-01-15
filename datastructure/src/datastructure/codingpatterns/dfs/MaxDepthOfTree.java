package datastructure.codingpatterns.dfs;

import datastructure.codingpatterns.bfs.TreeNode;

public class MaxDepthOfTree {
    public static void main(String[] args) {
        MaxDepthOfTree maxDepthOfTree = new MaxDepthOfTree();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(2);
        root.right.left.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(6);
        System.out.println("Max depth of tree: " + maxDepthOfTree.findDepth(root));
    }
    public int findDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = findDepth(root.left);
        System.out.println("leftDepth: " + leftDepth);
        int rightDepth = findDepth(root.right);
        System.out.println("rightDepth: " + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
