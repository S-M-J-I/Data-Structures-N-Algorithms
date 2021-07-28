package basic_data_structures.stack;

import basic_data_structures.list.Employee;

import java.util.EmptyStackException;


class StackWithArray{
    private Employee[] stack; // Declare a stack array
    private int top; // declare top, auto set as null

    public StackWithArray(int capacity) {
        stack = new Employee[capacity]; // initialize stack array with a capacity
    }

    public void push(Employee employee){

        /*
        *   Used to push an element into stack
        */

        if(top == stack.length){ // if top is the same as stack length, this means the stack is full
            //need to resize the backing array
            Employee[] newArray = new Employee[2 * stack.length]; // 2*stack length to increase size for push
            System.arraycopy(stack,0,newArray,0,stack.length); // copy stack into temp array with 2*size
            stack = newArray; // assign that temp array to stack
        }

        stack[top++] = employee; // increase top and assign data to the next stack pos
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public Employee pop(){
        if(isEmpty()){
            // if empty, throw a exception
            throw new EmptyStackException();
        }

        Employee e = stack[--top]; // else get the data that is one less than the top (remember top is always + 1 that element position)
        stack[top] = null; // assign top to null
        return e;
    }

    public Employee peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int getSize(){
        return top;
    }

    public void printStack(){
        for(int i=top-1; i>=0; i--){
            System.out.println(stack[i]+" ");
        }
    }
}


public class ArrayStack {

    public static void main(String[] args) {

        StackWithArray stack = new StackWithArray(5);
        System.out.println("First List: ");
        stack.push(new Employee("Jenny","Lane", 112));
        stack.push(new Employee("John","Doe", 312));
        stack.push(new Employee("Peter","Parker", 222));
        stack.push(new Employee("Jack","Juk", 222));
        stack.push(new Employee("Yes","Sir", 222));
        stack.printStack();
        System.out.println("POP : "+stack.pop());
        System.out.println("PEEK : "+stack.peek());
        System.out.println("Second List: ");
        stack.printStack();

    }
}
