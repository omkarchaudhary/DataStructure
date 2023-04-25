package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamProblem {
    static List<EmployeeDemo> employeeList = new ArrayList<EmployeeDemo>();

    public static void main(String[] args) {

        employeeList.add(new EmployeeDemo(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new EmployeeDemo(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new EmployeeDemo(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new EmployeeDemo(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new EmployeeDemo(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new EmployeeDemo(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new EmployeeDemo(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new EmployeeDemo(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new EmployeeDemo(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new EmployeeDemo(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new EmployeeDemo(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new EmployeeDemo(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new EmployeeDemo(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new EmployeeDemo(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new EmployeeDemo(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new EmployeeDemo(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new EmployeeDemo(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        // Query 1 : How many male and female employees are there in the organization?
        method1();
        System.out.println("\n");
        // Query 2 : Print the name of all departments in the organization?
        method2();
        System.out.println("\n");
        // Query 3 : What is the average age of male and female employees?
        method3();
        System.out.println("\n");
        // Query 4 : Get the details of highest paid employee in the organization?
        method4();
        System.out.println("\n");
        // Query 5 : Get the names of all employees who have joined after 2015?
        method5();
        System.out.println("\n");
        // Query 6 : Count the number of employees in each department?
        method6();
        System.out.println("\n");
        // Query 7 : What is the average salary of each department?
        method7();
        System.out.println("\n");
        // Query 8 : Get the details of youngest male employee in the product
        // development department?
        method8();
        System.out.println("\n");
        // Query 9 : Who has the most working experience in the organization?
        method9();
        System.out.println("\n");
        // Query 10 : How many male and female employees are there in the sales and
        // marketing team?
        method10();
        System.out.println("\n");
        // Query 11 : What is the average salary of male and female employees?
        method11();
        System.out.println("\n");
        // Query 12 : List down the names of all employees in each department?
        method12();
        System.out.println("\n");
        // Query 13 : What is the average salary and total salary of the whole
        // organization?
        method13();
        System.out.println("\n");
        // Query 14 : Separate the employees who are younger or equal to 25 years from
        // those employees who are older than 25 years.
        method14();
        System.out.println("\n");
        // Query 15 : Who is the oldest employee in the organization? What is his age
        // and which department he belongs to?
        method15();

    }

    public static void method1() {
        System.out.println("Query 1 : How many male and female employees are there in the organization?");
        Map<String, Long> noOfMaleAndFemaleEmployeeDemos = employeeList.stream()
                .collect(Collectors.groupingBy(EmployeeDemo::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployeeDemos);
    }

    public static void method2() {
        System.out.println("Query 2 : Print the name of all departments in the organization?");
        employeeList.stream().map(EmployeeDemo::getDepartment).distinct().forEach(System.out::println);
    }

    public static void method3() {
        System.out.println("Query 3 : What is the average age of male and female employees?");
        Map<String, Double> averageAgeOfMaleAndFemaleEmployeeDemo = employeeList.stream()
                .collect(Collectors.groupingBy(EmployeeDemo::getGender, Collectors.averagingInt(EmployeeDemo::getAge)));
        System.out.println(averageAgeOfMaleAndFemaleEmployeeDemo);
    }

    public static void method4() {
        System.out.println("Query 4 : Get the details of highest paid employee in the organization?");
        Optional<EmployeeDemo> highestPaidEmployeeDemoWrapper = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(EmployeeDemo::getSalary)));
        System.out.println(highestPaidEmployeeDemoWrapper.get().getName());
    }

    public static void method5() {
        System.out.println("Query 5 : Get the names of all employees who have joined after 2015?");
        employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(EmployeeDemo::getName)
                .forEach(System.out::println);
    }

    public static void method6() {
        System.out.println("Query 6 : Count the number of employees in each department?");
        Map<String, Long> employeeCountByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(EmployeeDemo::getDepartment, Collectors.counting()));

        Set<Map.Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();

        for (Map.Entry<String, Long> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void method7() {
        System.out.println("Query 7 : What is the average salary of each department?");
        Map<String, Double> avgSalaryOfDepartments=
                employeeList.stream().collect(Collectors.groupingBy(EmployeeDemo::getDepartment, Collectors.averagingDouble(EmployeeDemo::getSalary)));

        Set<Map.Entry<String, Double>> entrySet = avgSalaryOfDepartments.entrySet();

        for (Map.Entry<String, Double> entry : entrySet)
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    public static void method8() {
        System.out
                .println("Query 8 : Get the details of youngest male employee in the product development department?");
        Optional<EmployeeDemo> youngestMaleEmployeeDemoInProductDevelopmentWrapper=
                employeeList.stream()
                        .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
                        .min(Comparator.comparingInt(EmployeeDemo::getAge));

        EmployeeDemo youngestMaleEmployeeDemoInProductDevelopment = youngestMaleEmployeeDemoInProductDevelopmentWrapper.get();

        System.out.println("Details Of Youngest Male EmployeeDemo In Product Development");

        System.out.println("----------------------------------------------");

        System.out.println("ID : "+youngestMaleEmployeeDemoInProductDevelopment.getId());

        System.out.println("Name : "+youngestMaleEmployeeDemoInProductDevelopment.getName());

    }

    public static void method9() {
        System.out.println("Query 9 : Who has the most working experience in the organization?");
        Optional<EmployeeDemo> seniorMostEmployeeDemoWrapper=
                employeeList.stream().sorted(Comparator.comparingInt(EmployeeDemo::getYearOfJoining)).findFirst();

        EmployeeDemo seniorMostEmployeeDemo = seniorMostEmployeeDemoWrapper.get();

        System.out.println("Senior Most EmployeeDemo Details :");

        System.out.println("----------------------------");

        System.out.println("ID : "+seniorMostEmployeeDemo.getId());

        System.out.println("Name : "+seniorMostEmployeeDemo.getName());
    }

    public static void method10() {
        System.out.println("Query 10 : How many male and female employees are there in the sales and marketing team?");
        Map<String, Long> countMaleFemaleEmployeeDemosInSalesMarketing=
                employeeList.stream()
                        .filter(e -> e.getDepartment()=="Sales And Marketing")
                        .collect(Collectors.groupingBy(EmployeeDemo::getGender, Collectors.counting()));

        System.out.println(countMaleFemaleEmployeeDemosInSalesMarketing);
    }

    public static void method11() {
        System.out.println("Query 11 : What is the average salary of male and female employees?");
        Map<String, Double> avgSalaryOfMaleAndFemaleEmployeeDemos=
                employeeList.stream().collect(Collectors.groupingBy(EmployeeDemo::getGender, Collectors.averagingDouble(EmployeeDemo::getSalary)));

        System.out.println(avgSalaryOfMaleAndFemaleEmployeeDemos);
    }

    public static void method12() {
        System.out.println("Query 12 : List down the names of all employees in each department?");
        Map<String, List<EmployeeDemo>> employeeListByDepartment=
                employeeList.stream().collect(Collectors.groupingBy(EmployeeDemo::getDepartment));

        Set<Map.Entry<String, List<EmployeeDemo>>> entrySet = employeeListByDepartment.entrySet();

        for (Map.Entry<String, List<EmployeeDemo>> entry : entrySet)
        {
            System.out.println("--------------------------------------");

            System.out.println("EmployeeDemos In "+entry.getKey() + " : ");

            System.out.println("--------------------------------------");

            List<EmployeeDemo> list = entry.getValue();

            for (EmployeeDemo e : list)
            {
                System.out.println(e.getName());
            }
        }
    }

    public static void method13() {
        System.out.println("Query 13 : What is the average salary and total salary of the whole organization?");
        DoubleSummaryStatistics employeeSalaryStatistics=
                employeeList.stream().collect(Collectors.summarizingDouble(EmployeeDemo::getSalary));

        System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());

        System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());
    }

    public static void method14() {
        System.out.println(
                "Query 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
        Map<Boolean, List<EmployeeDemo>> partitionEmployeeDemosByAge=
                employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));

        Set<Map.Entry<Boolean, List<EmployeeDemo>>> entrySet = partitionEmployeeDemosByAge.entrySet();

        for (Map.Entry<Boolean, List<EmployeeDemo>> entry : entrySet)
        {
            System.out.println("----------------------------");

            if (entry.getKey())
            {
                System.out.println("EmployeeDemos older than 25 years :");
            }
            else
            {
                System.out.println("EmployeeDemos younger than or equal to 25 years :");
            }

            System.out.println("----------------------------");

            List<EmployeeDemo> list = entry.getValue();

            for (EmployeeDemo e : list)
            {
                System.out.println(e.getName());
            }
        }
    }

    public static void method15() {
        System.out.println(
                "Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?");
        Optional<EmployeeDemo> oldestEmployeeDemoWrapper = employeeList.stream().max(Comparator.comparingInt(EmployeeDemo::getAge));

        EmployeeDemo oldestEmployeeDemo = oldestEmployeeDemoWrapper.get();

        System.out.println("Name : "+oldestEmployeeDemo.getName());

        System.out.println("Age : "+oldestEmployeeDemo.getAge());

        System.out.println("Department : "+oldestEmployeeDemo.getDepartment());
    }

}

class EmployeeDemo {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public EmployeeDemo(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
                + department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
    }
}
