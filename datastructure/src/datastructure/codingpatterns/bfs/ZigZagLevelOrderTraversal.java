package datastructure.codingpatterns.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        ZigZagLevelOrderTraversal zigZagLevelOrderTraversal = new ZigZagLevelOrderTraversal();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> traverse = zigZagLevelOrderTraversal.traverse(root);
        traverse.stream().forEach(ls -> System.out.println(ls.toString()));
    }

    private List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()){
            List<Integer> currentLevel = new LinkedList<>();
            int size = queue.size();
            for(int i =0; i < size; i++){
                TreeNode currentNode = queue.poll();
                if(leftToRight){
                    currentLevel.add(currentNode.value);
                }else {
                    currentLevel.add(0, currentNode.value);
                }
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }

            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
