package collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionNeed {
    // delcaring multiple variable to store data is very bad approach
    // so we can have arrray to store data
    //Limitation of array
    //1. Arrays are fixed in size; solve by ArrayList
    //2.Arrays can hold only homogenous data elements
    //3. Readymade API is not available in the array
    public static void main(String[] args) {
        Student[] students = new Student[10];
        students[0] = new Student();
        //students[1] = new String("ABC");
        // Object can hold homogenous data as it super class of all class
        Object[] objects = new Object[10];
        objects[0] = new Student();
        objects[1] = new String("ABC");

    }
    public static  long playLists(List<Integer> songs){
        //[10,50,90,30] ==> multiple of 60

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int song : songs) {
            int val = song % 60; // 10, 50
            int rem = 60 - val; //50, 10
            if (map.containsKey(rem % 60))
            {
                count += map.get(rem % 60); //

            }
            map.put(song % 60, map.getOrDefault(song % 60, 0) + 1); //(10,10)
        }

        return count;
    }
    public static  long playList(List<Integer> songs){
        //[10,50,90,30] ==> multiple of 60

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int t : songs) {
            if (map.containsKey(((60 - t % 60)) % 60))
            {
                count += map.get((60 - t % 60) % 60);

            }
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }

        return count;
    }
}


class Student{}
