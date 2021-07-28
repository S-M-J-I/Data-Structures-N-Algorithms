package basic_data_structures.list;

class IntegerNode{
    private Integer number;
    private IntegerNode next;

    public IntegerNode(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public IntegerNode getNext() {
        return next;
    }

    public void setNext(IntegerNode next) {
        this.next = next;
    }
};

class IntegerLinkedList{
    private IntegerNode head;
    private static int size = 0;

    public void add2Front(Integer value){
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void printList(){
        IntegerNode current = head;
        while (current != null){
            System.out.print(current+" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void insertSorted(Integer value){
        if(isEmpty() || head.getNumber() >= value){
            return;
        }

        //find insertion point
        IntegerNode current = head.getNext();
        IntegerNode previous = head;
        while (current != null && current.getNumber()<value){
            previous = current;
            current = current.getNext();
        }

        IntegerNode newNode = new IntegerNode(value);
        newNode.setNext(current);
        previous.setNext(newNode);
        size++;
    }

    public int getSize() {
        return size;
    }
};

public class Testing {

    public static void main(String[] args) {
        IntegerLinkedList list = new IntegerLinkedList();
        Integer integer1 = 83;
        Integer integer2 = -83;
        Integer integer3 = 3;
        Integer integer4 = -36;
        Integer integer5 = 183;

        list.insertSorted(integer1);
        list.insertSorted(integer2);
        list.insertSorted(integer3);
        list.insertSorted(integer4);
        list.insertSorted(integer5);

        list.printList();

    }
}
