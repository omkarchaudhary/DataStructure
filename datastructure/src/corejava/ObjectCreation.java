package corejava;

import java.io.*;

public class ObjectCreation implements Cloneable{
    private String name = "Object";
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ObjectCreation obj = (ObjectCreation) Class.forName("corejava.ObjectCreation").newInstance();
        obj.getObject(obj);
        obj = new ObjectCreation();
        obj.getObject(obj);

        ObjectCreation objClone = (ObjectCreation) obj.clone();
        objClone.getObject(objClone);

        /// serializable the object
        FileOutputStream fileOutputStream = new FileOutputStream("car.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Car myCar = new Car();
        objectOutputStream.writeObject(myCar);
        objectOutputStream.close();
        fileOutputStream.close();

        //deserialization

        FileInputStream fileInputStream = new FileInputStream("car.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Car mySerializedObject = (Car) objectInputStream.readObject();
        System.out.println("The serialize object: "+mySerializedObject);

        Vehicle car  = new Car();
        car.drive();
    }
    public void getObject(Object obj){
        System.out.println(obj);
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
//using serialization
class Vehicle{
    public void drive(){
        System.out.println("The vehicle is drive");
    }
}
class Car extends Vehicle implements Serializable{
    public void engine(){
        System.out.println("The vehicle is car");
    }
}
