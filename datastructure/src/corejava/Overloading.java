package corejava;

public class Overloading {
    String display(String a){
        System.out.println(a);
        return a;
    }
    void display(int a){
        System.out.println(a);
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        overloading.display(2);
    }
}
