package datastructure.codingpatterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinDifferenceInBST {
    public static void main(String[] args) {
        MinDifferenceInBST minDifferenceInBST = new MinDifferenceInBST();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left =  new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println("Min difference: " + minDifferenceInBST.findMinDifference(root));
    }

    private int findMinDifference(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDifference = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode.left != null){
                queue.offer(currentNode.left);
                minDifference = Math.min(minDifference, currentNode.value - currentNode.left.value);
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
                minDifference = Math.min(minDifference, currentNode.right.value - currentNode.value);
            }
        }
        return minDifference;

    }
}
