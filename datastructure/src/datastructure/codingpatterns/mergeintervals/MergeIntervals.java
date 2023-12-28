package datastructure.codingpatterns.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode link: https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] result = mergeIntervals.merge(intervals);
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    private int[][] merge(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> results = new ArrayList<>();
        int[] currentInterval = intervals[0];
        results.add(currentInterval);
        for(int[] interval : intervals){
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            if(currentEnd >= nextBegin){
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }else{
                currentInterval = interval;
                results.add(currentInterval);
            }
        }
        return results.toArray(new int[results.size()][]);
    }
}
