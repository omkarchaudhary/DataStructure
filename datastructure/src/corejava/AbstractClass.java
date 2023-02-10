package corejava;

public class AbstractClass {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getString());
        test.display();
    }
}
abstract class Abstract {
    public Abstract() {
    }
    abstract String getString();
    void display(){
        System.out.println("I am in abstract");
    }
}

class Test extends  Abstract{

    @Override
    String getString() {
        return "I am abstract oveerid";
    }
}
