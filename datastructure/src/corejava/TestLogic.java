package corejava;

import java.io.File;
import java.io.IOException;

public class TestLogic {
    public static void main(String[] args) throws IOException, InterruptedException {
        Integer a = new Integer(10);
        Integer b = new Integer(20);
        int i = a + b;
        System.out.println(i);

        File tempFile = File.createTempFile("myFile",".txt");
        Thread.sleep(1000);
        tempFile.deleteOnExit();
        TestLogic testLogic = new TestLogic();
        System.out.println(testLogic);
    }
}
