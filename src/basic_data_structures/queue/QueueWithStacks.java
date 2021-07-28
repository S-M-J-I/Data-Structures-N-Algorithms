package basic_data_structures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class StackQueue{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void enQueue(int num){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(num);

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int deQueue(){
        if(stack1.isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }

        return stack1.pop();
    }

    public int peek(){
        return stack1.peek();
    }

    public void printQueue(){
        Iterator<Integer> iterator = stack1.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

};

public class QueueWithStacks {

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        System.out.println("Before Dequeue : ");
        queue.printQueue();
        queue.deQueue();
        System.out.println("After Dequeue : ");
        queue.printQueue();
        System.out.println("Peek : " + queue.peek());
    }
}
