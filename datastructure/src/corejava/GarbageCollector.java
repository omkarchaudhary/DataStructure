package corejava;

import java.io.FileReader;

public class GarbageCollector {
     GarbageCollector(){
        System.out.println("Constructor ");
    }
    @Override
    public void finalize(){
        System.out.println("Object is garbage collected");
    }

    public static void main(String[] args) {
        GarbageCollector gbc = new GarbageCollector();
        GarbageCollector gbc1 = new GarbageCollector();
        gbc = null;
        gbc1 = null;
        //System.out.println("The value of a "+ str);
        System.gc();
    }
}
