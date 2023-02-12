package ExceptionHandling;

import java.io.IOException;

public class MyException {
    // Checked exception is compile time exception should always be handle using try catch or throws in method declaration
    public static void main(String[] args) throws Exception {
        ExB b = new ExB();
        b.method1();
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
