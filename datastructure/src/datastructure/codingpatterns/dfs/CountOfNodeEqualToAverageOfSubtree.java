package datastructure.codingpatterns.dfs;
import datastructure.codingpatterns.bfs.TreeNode;

/**
 * leetcode link: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree
 */
public class CountOfNodeEqualToAverageOfSubtree {
    int count = 0;
    public static void main(String[] args) {
        CountOfNodeEqualToAverageOfSubtree countOfNodeEqualToAverageOfSubtree = new CountOfNodeEqualToAverageOfSubtree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left =  new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);
        System.out.println("Count of node equal to average of subtree: " + countOfNodeEqualToAverageOfSubtree.countOfNodeEqualToAverageOfSubtree(root));
    }

    private int countOfNodeEqualToAverageOfSubtree(TreeNode root) {
        if(root == null) return 0;
        findAverageOfSubtree(root, count);
        return count;
    }

    private Pair<Integer, Integer> findAverageOfSubtree(TreeNode root, int cnt) {
        if(root == null) return new Pair<>(0, 0);
        Pair<Integer, Integer> leftPair = findAverageOfSubtree(root.left, cnt);
        Pair<Integer, Integer> rightPair = findAverageOfSubtree(root.right, cnt);
        int sum = leftPair.value + rightPair.value + root.value;
        int nodeCount = leftPair.count + rightPair.count + 1;
        int avg= sum / nodeCount;
        if(avg == root.value){
            count++;
        }
        return new Pair<>(sum, nodeCount);
    }
}
