package datastructure.dsachallenge;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] stockPrice = new int[]{100,70,200,150,300};
        int maxProfit = maxProfit(stockPrice);
        System.out.println(maxProfit);
    }
    public static int maxProfit(int[] price){
        int buyPrice = price[0];
        int max = 0;
        for(int i = 1; i < price.length; i++){
            if((price[i] > buyPrice)){
                max = Math.max(price[i]-buyPrice,max);
            }else{
                buyPrice = price[i];
            }
        }
        return max;
    }
}
