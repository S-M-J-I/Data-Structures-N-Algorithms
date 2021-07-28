package basic_data_structures.stack;

import basic_data_structures.list.Employee;

class Node{
    private Employee employee;
    private Node nextNode;

    public Node(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
};

class LL{
    private Node head;
    private static int size = 0;

    public void add2Front(Employee e){
        Node add = new Node(e);
        add.setNextNode(head);
        head = add;
        size++;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public Node removeFromFront(){
        if(isEmpty()) return null;

        Node removeNode = head;
        head = head.getNextNode();
        size--;
        removeNode.setNextNode(null);
        return removeNode;
    }

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }
};

class StackWithLL{
    private LL list;

    public StackWithLL() {
        list = new LL();
    }

    public void push(Employee e){
        list.add2Front(e);
    }

    public Node pop(){
        return list.removeFromFront();
    }

    public Node peek(){
        return list.getHead();
    }

    public void traverseStack(){

    }
};


public class LLStackImplement {

    public static void main(String[] args) {

    }
}
