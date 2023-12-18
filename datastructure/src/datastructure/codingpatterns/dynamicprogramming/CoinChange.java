package datastructure.codingpatterns.dynamicprogramming;

/**
 * This is CoinChange problem. For a given array of coins, we have to find the minimum number of coin to make given amount
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins  = new int[]{1,5,6,9};
        int sum = 11;
        System.out.println(" The minimum coin required to make " +sum +" is "+minCoin(coins,sum));
    }

    private static int minCoin(int[] coins, int sum) {
        //create a dp of length amount +1
        int dp[] = new int[sum+1];
        for(int i = 1; i<= sum; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin <= i && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }

        if(dp[sum] == Integer.MAX_VALUE) return -1;

        return dp[sum];
    }
}
