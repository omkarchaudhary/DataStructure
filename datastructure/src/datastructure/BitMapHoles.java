package datastructure;

import java.util.ArrayList;
import java.util.Arrays;

public class BitMapHoles {

    public static String bitmapHoles(String[] str){
        if(str.length == 0){
            return null;
        }
        ArrayList<ArrayList<String>> strArray= new ArrayList<>();
        for(int i = 0; i< str.length; i++){
            strArray.add(new ArrayList<>(Arrays.asList(str[i].split(""))));
        }
        int result = helper(strArray);
        return String.valueOf(result);
    }

    public static int helper(ArrayList<ArrayList<String>> arr){
        int count = 0;
        for(int i = 0; i < arr.size(); i++){
            for(int j =0; j < arr.get(i).size(); j++){
                if(arr.get(i).get(j).equals("0")){
                    count++;
                    dfs(arr,i, j, arr.size(), arr.get(i).size());
                }
            }
        }
        return count;
    }

    public static void dfs(ArrayList<ArrayList<String>> arr, int i, int j, int row, int col){
        if(i < 0 || j < 0 || i > row-1 || j > col-1 || !arr.get(i).get(j).equals("0")){
            return;
        }

        if(arr.get(i).get(j).equals("0")){
            arr.get(i).set(j,"1");
            dfs(arr,i+1,j, row,col);
            dfs(arr,i-1,j,row,col);
            dfs(arr,i,j+1,row,col);
            dfs(arr,i,j-1,row,col);
        }
    }



    public static void main(String[] args) {
        String[] str = {"1011","0010"};
        System.out.println(bitmapHoles(str));
    }
}