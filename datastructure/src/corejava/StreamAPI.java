package corejava;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> list  = Arrays.asList(1,2,2,3,4,5,5);
        for (Integer i: getDuplicateNumber(list)) {
            System.out.println(i);
        }

        List<Job> jobs = Arrays.asList(
                new Job(1,"Java Developer","Java",110000.0,"Seattle"),
                new Job(2,"Dot net Developer",".Net",120000.0,"Seattle"),
                new Job(3,"Software Engineer","Java",150000.0,"Chicago"),
                new Job(4,"Full stack",".Net",210000.0,"New York"),
                new Job(5,"Software Engineer",".Net",140000.0,"Chicago")
        );

        Map<String, List<Job>> map = getListOfJobGroupByLocation(jobs);
        System.out.println(map.get("Chicago"));
         getListOfJobGroupByLocation(jobs);
        System.out.println(getListOfJobGroupByLocationUsingStream(jobs));

        // Average
        System.out.println("The average salary of job is "+getAverageSalary(jobs));
        System.out.println("The average Salary of job using Stream is "+ getAverageSalaryUsingStreamAPI(jobs));
    }

    // print the duplicate number in a array
    public static List<Integer> getDuplicateNumber(List<Integer> list){
          List<Integer> result = list.stream().filter(x -> Collections.frequency(list,x) > 1)
                  .distinct()
                .collect(Collectors.toList());
          return  result;
    }

    // find the job group by location
    public static Map<String,List<Job>> getListOfJobGroupByLocation(List<Job> jobs){
        Map<String,List<Job>> result  = new HashMap<>();

        for(int i  = 0; i< jobs.size(); i++){
            Job job = jobs.get(i);
            List<Job> map = result.getOrDefault(job.getLocation(),new ArrayList<>());
            map.add(job);
            result.put(job.getLocation(), map);
        }
        return result;
    }
    // find the job group by location using stream
    public static Map<String,List<Job>> getListOfJobGroupByLocationUsingStream(List<Job> jobs){
        return jobs.stream().collect(Collectors.groupingBy((s) -> s.getLocation()));
    }

    // find average salary of an employee
    public static double getAverageSalary(List<Job> jobs){
        int count  = 0;
        double sum = 0;
        for(Job job : jobs){
            sum += job.getSalary();
            count++;
        }
        return sum/count;
    }
    public static double getAverageSalaryUsingStreamAPI(List<Job> jobs){
        return jobs.stream()
                .mapToDouble(map -> map.getSalary())
                .average()
                .getAsDouble();
    }
}

class Job{
    private int id;
    private String title;
    private String tech;
    private double salary;
    private String location;

    public Job(int id, String title, String tech, double salary, String location) {
        this.id = id;
        this.title = title;
        this.tech = tech;
        this.salary = salary;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String
    toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tech='" + tech + '\'' +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                '}';
    }
}
