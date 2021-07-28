package basic_data_structures.hackkerank_practise;

import java.util.LinkedList;

import java.util.ListIterator;
import java.util.Scanner;

class MyStack{
    private LinkedList<Integer> stack;
    private int top;

    public MyStack() {
        stack = new LinkedList<Integer>();
    }

    public void push(int number){
        stack.push(number);
        top++;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public int pop(){
        return stack.pop();
    }

    public int findMax(){
        int max = stack.pop();

        ListIterator<Integer> iterator = stack.listIterator();
        while (iterator.hasNext()){
            if(max < iterator.next()){
                max = iterator.next();
            }
        }

        return max;
    }
};

public class StackMaximumElement {

    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int N = s.nextInt();
        MyStack stack = new MyStack();

        for(int i=0; i<N; i++){
            int opt = s.nextInt();
            s.next();

            switch (opt){
                case 1:{
                    int n = s.nextInt();
                    stack.push(n);
                    break;
                }
                case 2:{
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                }
                case 3:{
                    System.out.println(stack.findMax());
                    break;
                }
            }
        }
    }
}
