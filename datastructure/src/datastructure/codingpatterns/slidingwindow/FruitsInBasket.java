package datastructure.codingpatterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode link : https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitsInBasket {
    public static void main(String[] args) {
        FruitsInBasket fruitsInBasket = new FruitsInBasket();
        int[] fruits = {1,1,2,2,3,3,3};
        System.out.println("The max fruits in 2 basket is "+ fruitsInBasket.totalFruit(fruits));
    }
    public int totalFruit(int[] fruits) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for( int windowEnd = 0; windowEnd < fruits.length; windowEnd++){

            map.put(fruits[windowEnd], map.getOrDefault(fruits[windowEnd],0)+1);
            while(map.size() > 2){
                map.put(fruits[windowStart],map.get(fruits[windowStart])-1);
                if(map.get(fruits[windowStart]) == 0){
                    map.remove(fruits[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }

        return maxLength;
    }
}
