package datastructure;

public class IsLand {

    public static int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j =0; j< col; j++){
                if(grid[i][j]== '1'){
                    count++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid, int i, int j, int row, int col){
        //base case
        if(i<0 || j<0 || i > (row-1) || j > (col-1) || grid[i][j] != '1' ){
            return;
        }

        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i+1, j, row, col);
            dfs(grid, i-1, j, row, col);
            dfs(grid, i, j+1, row, col);
            dfs(grid, i, j-1, row, col);

        }

    }
}
