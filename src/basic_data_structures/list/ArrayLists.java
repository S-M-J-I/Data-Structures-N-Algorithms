package basic_data_structures.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayLists {



    public static void main(String[] args) {

        //Declare List then ArrayList
        List<Employee> employeeList = new ArrayList<>();

        //Add to ArrayList object
        employeeList.add(new Employee("Jack","Bauer",1838));
        employeeList.add(new Employee("John","Doe",3543));
        employeeList.add(new Employee("Frank","Ocean",6756));
        employeeList.add(new Employee("Danny","Williams",5463));

        //Print out the list
        System.out.println("Employee List:");
        employeeList.forEach(employee -> System.out.println(employee+" "));

        //Get the object at that particular index
        System.out.println(employeeList.get(0).toString());

        //Check if list is empty
        System.out.println(employeeList.isEmpty());


        System.out.println("Employee Array: ");
        //Object array }----> toArray copies list into array
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for(Employee e : employeeArray){
            System.out.println(e);
        }

        //Finds employee
        System.out.println(employeeList.contains(new Employee("Danny","Williams",5463)));

        //Finds Object index in list
        System.out.println(employeeList.indexOf(new Employee("Danny","Williams",5463)));

        //Remove Employee
        //Either with index,
        employeeList.remove(2);
        //Or by passing the object
        employeeList.remove(new Employee("Danny","Williams",5463));

    }



}
