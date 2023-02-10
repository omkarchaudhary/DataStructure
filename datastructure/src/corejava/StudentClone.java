package corejava;

public class StudentClone implements Cloneable {
    private int rollNo;
    private String name;

    public StudentClone(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public  Object clone() throws CloneNotSupportedException{
        return null;
    }

    @Override
    public String toString() {
        return "StudentCLone{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        try{
            StudentClone studentClone = new StudentClone(101,"John");
            StudentClone studentClone1 = (StudentClone) studentClone.clone();
            System.out.println(studentClone);
            System.out.println(studentClone1);
        }catch (CloneNotSupportedException c){
            System.out.println("CloneNotSupportedException occures");
        }
    }
}
