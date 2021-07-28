package basic_data_structures.list;

import java.util.List;
import java.util.Vector;

public class Vectors {

    public static void main(String[] args) {
        List<Employee> employeeList = new Vector<>();

        //Add to ArrayList object
        employeeList.add(new Employee("Jack","Bauer",1838));
        employeeList.add(new Employee("John","Doe",3543));
        employeeList.add(new Employee("Frank","Ocean",6756));
        employeeList.add(new Employee("Danny","Williams",5463));

        /*SAME AS ARRAYLIST*/
    }
}
