package datastructure.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] input = new int[]{6,3,5,7,2,1};
        insertionSort(input);
        for(int i : input){
            System.out.print(i+ " ");
        }
    }

    private static void insertionSort(int[] input) {
        int n  = input.length;

        for(int i = 1; i< n; i++){ //unsorted part
            int temp = input[i];
            int j = i-1;//sorted part

            while(j >= 0 && input[j] > temp){
                input[j+1] = input[j];
                j = j-1;
            }
            input[j+1] = temp;
        }
    }
}
