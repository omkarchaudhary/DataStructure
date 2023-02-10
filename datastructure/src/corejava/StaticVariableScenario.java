package corejava;

public class StaticVariableScenario {
    String empName; // non static variable
    static int empCount;// using static , its update the count across all the objects of Employee;

    public StaticVariableScenario(String empName) {
        this.empName = empName;
        empCount++;
    }

    public String getEmpName() {
        return empName;
    }

    public static int getEmpCount(){
        return empCount;
    }
    public static String getEmployee(){
        return null;
        //return this.empName shows compile error, 'this' can never be used in static block
    }
    public int getEmpCountWithoutStatic(){
        return empCount;
    }

    public static void main(String[] args) {
        StaticVariableScenario abc = new StaticVariableScenario("ABC");
        StaticVariableScenario def = new StaticVariableScenario("DEF");
        System.out.println(StaticVariableScenario.getEmpCount());
        System.out.println(abc.getEmpCountWithoutStatic());
    }
}
