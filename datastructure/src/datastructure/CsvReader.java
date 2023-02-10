package datastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvReader {
    public static void main(String[] args) throws FileNotFoundException {

        List<List<String>> records = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\MIU\\Java\\DataStructure\\datastructure\\src\\assets\\employee.csv"))) {
            reader.readLine();// reading firstLine
            String line = "";
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                records.add(Arrays.asList(data));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;

        System.out.println("Total Number of Employee: \n"+ records.size());
        for(List<String> ls : records){
            System.out.println(ls.toString());
        }
    }
}
