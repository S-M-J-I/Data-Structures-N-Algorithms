package basic_data_structures.list;


//--------------------------------Node class--------------------------
class EmployeeNode{

    private Employee employee;
    private EmployeeNode next;
    private EmployeeNode previous;

    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    public EmployeeNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeNode previous) {
        this.previous = previous;
    }

    public String toString(){
        return employee.toString();
    }
};


class EmployeeLinkedList{

    private EmployeeNode head;
    private static int size = 0;

    public void add2Front(Employee e){
        EmployeeNode node = new EmployeeNode(e);
        node.setNext(head);
        head = node;
        size++;
    }

    public EmployeeNode removeFromFront(){
        if(isEmpty()) return null;

        EmployeeNode removeNode = head;
        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return removeNode;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public int getSize() {
        return size;
    }

    public void printList(){
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }

        System.out.println("Null");
    }
};

public class SingleLinkedList {
    public static void main(String[] args) {
        Employee jackBauer = new Employee("Jack","Bauer",1838);
        Employee johnDoe = new Employee("John","Doe",3543);
        Employee frankOcean = new Employee("Frank","Ocean",6756);
        Employee dannyWilliams = new Employee("Danny","Williams",5463);

        EmployeeLinkedList list = new EmployeeLinkedList();
        System.out.println(list.isEmpty());
        list.add2Front(jackBauer);
        list.add2Front(johnDoe);
        list.add2Front(frankOcean);
        list.add2Front(dannyWilliams);
        System.out.println(list.isEmpty());

        list.printList();
        System.out.println(list.getSize());
        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();

    }
}