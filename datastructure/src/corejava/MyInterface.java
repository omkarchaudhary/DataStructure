package corejava;

interface MyInterfaceOne{
    int count = 10;
    void display();
}
interface MyInterfaceTwo{
    int count = 10;
    void display();
}

public class MyInterface implements MyInterfaceOne,MyInterfaceTwo {

    static int num = 10;
    String name = "Static";
    public static void main(String[] args) {
        MyInterfaceOne myInterfaceTwo = new MyInterface();
        myInterfaceTwo.display();
    }
    @Override
    public void display() {
        System.out.println("The static num value is: "+ name +" "+ num);
        System.out.println("I am in class");
    }
    public static void getDisplay(){
        // cannot have non-static instance variable in static method
        System.out.println(num);
    }
}

