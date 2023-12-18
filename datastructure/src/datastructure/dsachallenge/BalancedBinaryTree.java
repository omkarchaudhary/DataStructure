package datastructure.dsachallenge;

public class BalancedBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

    }
    public static TreeNode newNode(int val){
        TreeNode treeNode = new TreeNode();
        treeNode.val = val;
        treeNode.left = null;
        treeNode.right = null;
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode root = null;

        /* Constructing tree given in the above figure
            10
            / \
            30 15
        /     \
        20     5 */
        root = newNode(10);
        root.left = newNode(30);
        root.right = newNode(15);
        root.left.left = newNode(20);
        root.right.right = newNode(5);
        boolean balanced = isBalanced(root);
        System.out.println("The tree is balanced "+ balanced);
    }
    public static boolean isBalanced(TreeNode root){
        if(root == null) return true;
        if(Math.abs(getHeight(root.right))-Math.abs(getHeight(root.left)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right)+1;
    }


}
