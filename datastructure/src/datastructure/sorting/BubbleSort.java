package datastructure.sorting;


// in Bubble sort, we are comparing two adjacent element and in each outer iteration the max element will be at last.
public class BubbleSort {
    public static void main(String[] args) {
        int[] input = new int[]{5,3,4,1,6,2};
        bubbleSort(input);
        for(int i : input){
            System.out.print(i);
        }
    }

    public static void bubbleSort(int[] input){
        //boolean swaped = false; for sorted element
        for(int i = 0;i < input.length; i++){
            for(int j = 0; j< input.length-i-1; j++){
                if(input[j+1] < input[j]){
                    swap(input,j, j+1);
                    //swaped=true;
                }
                //if(!swaped) break;
            }
        }
    }

    public static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j]= temp;
    }
}
