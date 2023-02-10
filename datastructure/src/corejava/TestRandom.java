package corejava;

import java.io.Serializable;

public class TestRandom implements Serializable {
    private static TestRandom testRandom;
    int value;
    Test2 test;

    void display(String str) {
        System.out.println("This is transient from " + str);
    }

    public static void main(String[] args) {
        TestRandom testRandom = new TestRandom();
        //testRandom.display(testRandom.test.str);
        int x = 1;
        for(int i =1; i< 100 ; i +=i){
            x += x;
        }
        System.out.println("The output is "+x);
        
    }
}

class Test2 {
    String str = "Test2";

}
