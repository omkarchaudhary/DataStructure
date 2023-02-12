package corejava;

import java.io.*;

// By default when we serialize the parent class then child class will be serialize.
class Parent implements Serializable{
     int x;

}
class Child extends Parent{
    // transient keyword is used to prevent data from being serialized.
    //transient int z;
    int y;

    //to prevent a child class from being serialized, we need to override the writeObect() and readObject() method which do nothing
    //as an example
    /*
    private void writeObject(ObjectOutputStream outputStream){
        //do nothing
    }
    private void readObject(ObjectInputStream inputStream){
        //do nothing
    } */
}

public class SerializationClass {
    public static void main(String[] args) throws FileNotFoundException {
        Parent parent = new Parent();
        Child child = new Child();
        parent.x = 10;
        child.x= 20;child.y=30;

        try{
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream("parent.ser"));
            objectOutputStream.writeObject(parent);
            objectOutputStream.writeObject(child);
            objectOutputStream.close();

            //Deserialize

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("parent.ser"));
            Parent deserializedParent = (Parent) objectInputStream.readObject();
            Child deserializedChild = (Child)objectInputStream.readObject();
            System.out.println("Deserialized Parent: "+ deserializedParent.x);
            System.out.println("Deserialized Child: "+ deserializedChild.y);
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
