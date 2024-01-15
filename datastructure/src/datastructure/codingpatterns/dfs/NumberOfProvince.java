package datastructure.codingpatterns.dfs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvince {
    public static void main(String[] args) {
        NumberOfProvince numberOfProvince = new NumberOfProvince();
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> ls1 = new ArrayList<>();
        ls1.add(1);
        ls1.add(1);
        ls1.add(0);
        List<Integer> ls2 = new ArrayList<>();
        ls2.add(1);
        ls2.add(1);
        ls2.add(0);
        List<Integer> ls3 = new ArrayList<>();
        ls3.add(0);
        ls3.add(0);
        ls3.add(1);
        adjList.add(ls1);
        adjList.add(ls2);
        adjList.add(ls3);
        System.out.println("Number of provinces: " + numberOfProvince.findNumberOfProvinces(adjList, 3));
        int[][] adjMatrix = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("Number of provinces: " + numberOfProvince.findNumberOfProvince(adjMatrix));
    }

    private String findNumberOfProvince(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        int count = 0;
        for(int i =0; i < adjMatrix.length; i++){
            if(!visited[i]){
                dfsMatrx(adjMatrix, visited, i);
                count++;
            }
        }
        return String.valueOf(count);
    }

    private void dfsMatrx(int[][] adjMatrix, boolean[] visited, int i) {
        visited[i] = true;
        for(int j =0; j < adjMatrix.length; j++){
            if(!visited[j] && adjMatrix[i][j] == 1){
                dfsMatrx(adjMatrix, visited, j);
            }
        }
    }

    private String findNumberOfProvinces(List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i =0; i < n; i++){
            if(!visited[i]){
                dfs(adj, visited, i);
                count++;
            }
        }
        return String.valueOf(count);
    }
    private void dfs(List<List<Integer>> adj, boolean[] visited, int index){
        visited[index] = true;
        List<Integer> ls = adj.get(index);
        for(int i =0; i < ls.size(); i++){
            if(!visited[i] && ls.get(i) == 1){
                dfs(adj, visited, i);
            }
        }
    }
}
