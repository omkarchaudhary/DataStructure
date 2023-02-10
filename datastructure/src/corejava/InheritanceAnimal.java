package corejava;

class  Animals{
    void walk(){
        System.out.println("Animal walk");
    }
}

class Mammals extends Animals{
    void feedMilk(){
        System.out.println("Mammals feed milk");
    }
}

class Dogs extends Mammals{
    void bark(){
        System.out.println("Dog bark");
    }
}
public class InheritanceAnimal {
    public static void main(String[] args) {
        Dogs dogs = new Dogs();
        dogs.bark();
        dogs.feedMilk();
        dogs.walk();
    }
}
