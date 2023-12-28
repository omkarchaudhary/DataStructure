package datastructure.codingpatterns.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {
    public static void main(String[] args) {
        MinimumMeetingRooms minimumMeetingRooms = new MinimumMeetingRooms();
        int[][] intervals = {{1,4},{2,5},{7,9}};
        System.out.println("Minimum meeting rooms required: " + minimumMeetingRooms.findMinimumMeetingRooms(intervals));
    }

    private int findMinimumMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval : intervals){
            if(!pq.isEmpty() && pq.peek() <= interval[0]){
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size(); //TODO  - complete this method  -  https://www.educative.io/courses/grokking-the-coding-interview/3jwVx84OMkO

    }
}
