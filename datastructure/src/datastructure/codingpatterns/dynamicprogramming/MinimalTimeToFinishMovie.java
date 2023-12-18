package datastructure.codingpatterns.dynamicprogramming;

import java.util.List;

public class MinimalTimeToFinishMovie {
    public static void main(String[] args) {
        List<Integer> dReleaseTime = List.of(1,3,2);
        List<Integer> dDuration = List.of(2,3,2);
        List<Integer> cReleaseTime = List.of(2,3,1);
        List<Integer> cDuration = List.of(2,3,2);
        int result = minTimeToFinishMovies(dReleaseTime,dDuration,cReleaseTime, cDuration);
        System.out.println("The min time to finish "+ result);
    }
    public static int minTimeToFinishMovies(List<Integer> dReleaseTime, List<Integer> dDuration, List<Integer> cReleaseTime, List<Integer> cDuration){
        int n = dReleaseTime.size();
        int m = cReleaseTime.size();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i<=n; i++){
            int dTime = dReleaseTime.get(i-1);
            int dDurations = dDuration.get(i-1);
            for(int j = 1; j<=m; j++){
                int cTime = cReleaseTime.get(j-1);
                int cDurations = cDuration.get(j-1);
                 int timeWithoutDrama = dp[i-1][j];
                 int timeWithoutComedy = dp[i][j-1];
                 dp[i][j] = Math.max(timeWithoutDrama,timeWithoutComedy);
                 if(dTime+dDurations <= cTime){
                     dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + dDurations);
                 }
                 if(cTime+cDurations <= dTime){
                     dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + cDurations);
                 }
            }
        }
        return dp[n][m];
    }
}
