package corejava;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;

public class ComparableAndComparator  {
    public static void main(String[] args) {
        // Comparable
        Student[] students = new Student[]{
                new Student(1,"Rajesh",89),
                new Student(5,"Shyam",98),
                new Student(3,"Maniraj",85),
                new Student(2,"Yash",100),
        };
        //Arrays.sort(students,new NameComparator());
        System.out.println(Arrays.toString(students));
        Arrays.sort(students,new MarkComparator());
        System.out.println(Arrays.toString(students));

    }
}

class NameComparator implements java.util.Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class MarkComparator implements java.util.Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
         if(o1.getMarks() < o2.getMarks()){
             return -1;
         }else if(o1.getMarks() > o2.getMarks()){
             return 1;
         } else{
             return 0;
         }
    }
}
//class Student implements  Comparable<Student>{
    class Student implements Serializable {
    // Natural ordering, Compare with the same type of Object, has CompareTo() method
    private int rollNo;
    private String name;
    private int marks;

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

//    @Override
//    public int compareTo(Student student) {
//        return this.marks - student.getMarks();
//    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo='" + rollNo + '\'' +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
