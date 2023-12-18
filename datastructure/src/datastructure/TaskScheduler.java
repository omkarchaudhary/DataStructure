package datastructure;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        char [] tasks = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks, 2));
    }
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskFreq = new HashMap<>();
        for (char task : tasks) {
            taskFreq.put(task, taskFreq.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(taskFreq.values());

        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }

            for (int freq : temp) {
                if (freq - 1 > 0) {
                    maxHeap.offer(freq - 1);
                }
            }

            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return cycles;
    }
}
