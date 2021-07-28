package basic_data_structures.queue;

import java.util.*;

class MyPriorityQueue {
    private int[] queue;
    private int front;
    private int back;

    public MyPriorityQueue(int capacity){
        queue = new int[capacity];
    }

    public void enqueue(int num){
        if(back == queue.length){
            int[] newArray = new int[queue.length * 2];
            System.arraycopy(queue,0,newArray,0,queue.length);
            queue = newArray;
        }

        queue[back] = num;
        back++;

    }

    public void makeQueue(){
        Arrays.sort(queue);
    }

    public boolean isEmpty(){
        return (front-back) == 0;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        int removeIdx = front;
        front++;
        if(isEmpty()){
            front = 0;
            back = 0;
        }

        return queue[removeIdx];
    }

    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public void printQueue(){
        for(int i=front; i<back; i++){
            System.out.println(queue[i]);
        }
    }
};


public class PriorityQueue {

    public static void main(String[] args) {
        MyPriorityQueue priorityQueue = new MyPriorityQueue(10);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(4);
        priorityQueue.enqueue(9);
        priorityQueue.enqueue(19);
        priorityQueue.enqueue(4);

        System.out.println("First print : ");
        priorityQueue.printQueue();
        System.out.println("Peek : "+ priorityQueue.peek());
    }
}
