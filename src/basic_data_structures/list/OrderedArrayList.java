package basic_data_structures.list;

import java.util.*;

class Student{
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                "roll='"+ id + '\'' +
                '}';
    }
};

class SortByRoll implements Comparator<Student>{

    public int compare(Student a, Student b){
        //sorts in ascending order
        return a.getId()-b.getId();
    }
};

class SortByName implements Comparator<Student>{

    public int compare(Student a, Student b){
        return a.getName().compareTo(b.getName());
    }

};

public class OrderedArrayList {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Johnathon",1000));
        list.add(new Student("Abigail",9000));
        list.add(new Student("Rashford",5000));
        list.add(new Student("Peter",2000));


        System.out.println("Unsorted: ");
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i).toString());
        }

        Collections.sort(list, new SortByRoll());

        System.out.println("Sorted by Roll Number: ");
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i).toString());
        }

        Collections.sort(list, new SortByName());

        System.out.println("Sorted by Name: ");
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }
}
