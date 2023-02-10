package datastructure;

import java.util.PriorityQueue;

public class KthLargestElement {
     public static void main(String[] args) {
          int [] arr = new int[]{10,50, 20, 60, 30, 90,80};
          int kth = 3;
          System.out.println("The kth largest element is "+ largestElement(arr, kth));
     }

     private static int largestElement(int[] arr, int k) {
          PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

          for(int i  = 0; i < k ; i++){
               priorityQueue.offer(arr[0]);
          }
          for(int i = k; i < arr.length; i++){
               if(priorityQueue.peek() < arr[i]){
                    priorityQueue.poll();
                    priorityQueue.offer(arr[i]);
               }
          }
          return priorityQueue.peek();
     }

}
