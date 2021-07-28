package basic_data_structures.queue;

import basic_data_structures.list.Employee;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class LinkedListQueue{
    private LinkedList<Employee> queue;
    private int front;
    private int back;

    public LinkedListQueue() {
        queue = new LinkedList<Employee>();
    }

    public void add(Employee e){
        queue.add(e);
        back++;
    }

    public Employee remove(){
        if(queue.isEmpty()){
            throw new NoSuchElementException();
        }

        return queue.remove(front);
    }

    public Employee peek(){
        if(queue.isEmpty()){
            throw new NoSuchElementException();
        }

        return queue.peek();
    }

    public void printQueue(){
        ListIterator<Employee> iterator = queue.listIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
};

public class LLQueue {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane","Jones",92192);
        Employee johnDoe = new Employee("John","Doe",342192);
        Employee marySmith = new Employee("Mary","Smith",587192);
        Employee mikeWilson = new Employee("Mike","Wilson",92582);
        Employee billEnd = new Employee("Bill","End",92782);

        LinkedListQueue queue = new LinkedListQueue();
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marySmith);
        queue.add(mikeWilson);
        queue.add(billEnd);

        System.out.println("Printed first : ");
        queue.printQueue();

        System.out.println("Peek : "+queue.peek());
        queue.remove();
        queue.remove();
        System.out.println("Peek : "+queue.peek());

        queue.printQueue();
    }
}
