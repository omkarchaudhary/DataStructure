package ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyException {
    // Checked exception is compile time exception should always be handle using try catch or throws in method declaration
    public static void main(String[] args){
//        ExB b = new ExB();
//        b.method1();
        try (FileReader fileReader = new FileReader("abc")) {
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void method1() throws RuntimeException{

    }
}

class ExA{
    public void method1() throws Exception{
        System.out.println("I am in class A");
    }
}

//Higher Level checked exception always should be overriden in parent class

class ExB extends ExA{
    public void method1() {
        System.out.println("I am in class B");
    }
}
