package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int direction[][] = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            for (int d[] : direction) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || mat[r][c] != -1) continue;
                queue.add(new int[]{r, c});
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int mat[][] = updateMatrix(matrix);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}

