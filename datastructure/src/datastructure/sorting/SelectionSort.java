package datastructure.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] input = new int[]{6,3,5,7,2,1};
        selectionSort(input);
        for(int i : input){
            System.out.print(i+ " ");
        }
    }

    private static void selectionSort(int[] input) {
        int n  = input.length;

        for(int i = 0; i< n-1; i++){ //unsorted part
            int min = i;
            for(int j = i+1; j<n ; j++){
                if(input[j] < input[min]){
                    min =j;
                }
            }
            if (min != i) {
                swap(input,min, i);
            }
        }
    }

    public static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j]= temp;
    }
}
