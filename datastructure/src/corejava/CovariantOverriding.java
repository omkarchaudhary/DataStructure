package corejava;

import java.io.IOException;
import java.security.PublicKey;

public class CovariantOverriding {
    public static void main(String[] args) throws IOException {
        Animal animal = new Dog();
        animal.getParentObject();
        animal.getStringObject();
    }
}

class Animal{
    public Object getParentObject(){
        System.out.println("Parent Object");
        return "Parent Object";
    }

    public String getStringObject() throws IOException{
        System.out.println("parent exception");
        return "Parent exception";
    }
}

class Dog extends Animal{
    //Return type of child method is subclass of return type of Parent class- This is Covariant Method
    public String getParentObject(){
        System.out.println("Child Object");
        return "Child Object";
    }

    public String getStringObject(){
        System.out.println("Child Exception");
        return "Child without exception";
    }
}
