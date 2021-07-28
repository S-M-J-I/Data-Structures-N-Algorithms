package basic_data_structures.stack;

import basic_data_structures.list.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

class LinkedStack{

    private LinkedList<Employee> stack;

    public LinkedStack(){
        stack = new LinkedList<Employee>();
    }

    public void push(Employee employee){
        stack.push(employee);
    }

    public Employee pop(){
        return stack.pop();
    }

    public Employee peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void printStack(){

        ListIterator<Employee> iterator = stack.listIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


};


public class LLStack {

    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();
        stack.push(new Employee("Jenny","Lane", 112));
        stack.push(new Employee("John","Doe", 312));
        stack.push(new Employee("Peter","Parker", 222));
        stack.push(new Employee("Jack","Juk", 222));
        stack.push(new Employee("Yes","Sir", 222));

        stack.printStack();
    }
}
