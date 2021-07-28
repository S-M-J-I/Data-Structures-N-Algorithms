package basic_data_structures.queue;

import basic_data_structures.list.Employee;

import java.util.NoSuchElementException;

class MyQueue{

    private Employee[] queue;
    private int front;
    private int back;

    public MyQueue(int capacity){
        queue = new Employee[capacity];
    }

    public void add(Employee employee){
        if(back==queue.length){
            Employee[] newArray = new Employee[queue.length*2];
            System.arraycopy(queue,0,newArray,0,queue.length);
            queue = newArray;
        }

        queue[back] = employee;
        back++;
    }

    public boolean isEmpty(){
        return (back-front)==0;
    }

    public Employee remove(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        Employee removedEmployee = queue[front];
        queue[front] = null;
        front++;
        if(isEmpty()){
            front = 0;
            back = 0;
        }

        return removedEmployee;
    }

    public Employee peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public void printQueue(){
        for(int i=front ; i<back; i++){
            System.out.println(queue[i]);
        }
    }
};

public class ArrayQueue {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane","Jones",92192);
        Employee johnDoe = new Employee("John","Doe",342192);
        Employee marySmith = new Employee("Mary","Smith",587192);
        Employee mikeWilson = new Employee("Mike","Wilson",92582);
        Employee billEnd = new Employee("Bill","End",92782);

        MyQueue queue = new MyQueue(10);
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marySmith);
        queue.add(mikeWilson);
        queue.add(billEnd);

        queue.printQueue();

        System.out.println("Peek : "+queue.peek());
        queue.remove();
        queue.remove();
        System.out.println("Peek : "+queue.peek());

        queue.printQueue();

        
    }
}
