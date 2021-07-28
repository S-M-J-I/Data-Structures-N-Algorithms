package basic_data_structures.list;

class DoubleLinkedList{
    private EmployeeNode head;
    private EmployeeNode tail;
    private static int size = 0;

    public void add2Head(Employee e){
        EmployeeNode node = new EmployeeNode(e);


        if(head == null){
            tail = node;
        }else{
            node.setNext(head);
            head.setPrevious(node);
        }

        node.setPrevious(null);
        head = node;
        size++;
    }

    public void add2Tail(Employee e){
        EmployeeNode node = new EmployeeNode(e);
        if(tail == null){
            head = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public EmployeeNode removeFromHead(){
        if(isEmpty()) return null;

        EmployeeNode removeNode = head;

        if(head.getNext() == null){
            tail = null;
        }else{
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return removeNode;
    }

    public EmployeeNode removeFromTail(){
        if(isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = tail;

        if(tail.getPrevious() == null){
            head = null;
        }else{
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public boolean addBefore(Employee newE, Employee beforeE){

        if(isEmpty()) {
            return false;
        }

        EmployeeNode current = head;
        while (current != null && !current.getEmployee().equals(beforeE)){
            current = current.getNext();
        }

        if(current == null){
            return false;
        }

        EmployeeNode newNode = new EmployeeNode(newE);

        //set new node fields
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);

        //set current node fields
        current.setPrevious(newNode);
        if(head == current){
            head = newNode;
        }else{
            newNode.getPrevious().setNext(newNode);
        }

        size++;
        return true;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void printList(){
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }

        System.out.println("Null");
    }

    public int getSize() {
        return size;
    }
}

public class DoublyLinkedList {

    public static void main(String[] args) {

        Employee jackBauer = new Employee("Jack","Bauer",1838);
        Employee johnDoe = new Employee("John","Doe",3543);
        Employee frankOcean = new Employee("Frank","Ocean",6756);
        Employee dannyWilliams = new Employee("Danny","Williams",5463);

        DoubleLinkedList list = new DoubleLinkedList();
        list.add2Tail(jackBauer);
        list.add2Head(frankOcean);
        list.add2Head(johnDoe);


        System.out.println("Before add:");
        list.printList();

        /*
        list.removeFromHead();
        list.printList();

        list.removeFromTail();
        list.printList();
        */
        Employee newEmp = new Employee("James","Bond",7);

        list.addBefore(newEmp,frankOcean);

        list.printList();
    }
}
