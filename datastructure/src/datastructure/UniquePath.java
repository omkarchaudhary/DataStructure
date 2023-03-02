package datastructure;

public class UniquePath {
    private static int uniquePathsUtil(int m, int n, int[][] dp) {
        if(m == 1 || n == 1) return 1;
        //if(dp[m][n] != 0)
            //return dp[m][n];
        return dp[m][n] = uniquePathsUtil(m-1, n, dp) + uniquePathsUtil(m, n-1, dp);
    }
    private static int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        return uniquePathsUtil(m, n, dp);
    }

    // Recursive

    private static int uniquePathUsingRecursive(int m, int n){
        if(m ==1 || n==1) return 1;

        return uniquePathUsingRecursive(m-1,n)+uniquePathUsingRecursive(m,n-1);
    }

    public static void main(String[] args){
        //System.out.print(uniquePathUsingRecursive(3,4));
        System.out.print(uniquePaths(3,4));
    }
}
