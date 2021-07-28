package basic_data_structures.heaps;


class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        this.heap = new int[capacity];
    }

    private boolean isFull(){
        return size == heap.length;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    //we want to get child.
    //we take index, and if we want left child (true) or not (false)
    private int getChild(int index, boolean left){
        //LEFT CHILD: 2*index + 1
        //RIGHT CHILD: 2*index + 2
        return 2*index + (left ? 1 : 2);
    }

    private int getParent(int index){
        //formula for getting the parent
        return (index - 1) / 2;
    }

    private void fixHeapAbove(int index){
        int newValue = heap[index];

        // while (index > 0) : means while we haven't hit the root
        // while (newValue > heap[getParent(index)] : means while the newValue is greater than the value of its parent
        while (index > 0 && newValue > heap[getParent(index)]){
            heap[index] = heap[getParent(index)]; // assign parent to where the newValue currently lives
            index = getParent(index); // shift the position of index to parents position
        }

        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            //this node has a left child
            if(leftChild <= lastHeapIndex){
                if(rightChild > lastHeapIndex){
                    //it does not have a right child
                    childToSwap = leftChild;
                }else{
                    //if the value at left child pos is > right child pos value, then put left child as child to swap otherwise right
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                //if replacement val is < its largest child
                if(heap[index] < heap[childToSwap]){
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }else{
                    //if no swapping, break
                    break;
                }

                index = childToSwap;
            }else{
                //if no children
                break;
            }


        }
    }

    public void insert(int value){
        if(isFull()){
            throw new IndexOutOfBoundsException("Heap is full");
        }

        //post increment, we assign the value to heap[size] then after
        //it is inserted size will increase by +1;
        heap[size] = value;

        //fix heap
        fixHeapAbove(size);
        //then increment size
        size++;
    }

    //why take index ? if you take value, you have to search it
    public int delete(int index){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Heap Empty");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        //size-1 : because size always contains next available position
        heap[index] = heap[size-1];

        //if heap[index] > parent : fix above
        //if heap[index] < parent : fix below

        //if we're dealing with the root OR if value < parent
        if(index == 0 || heap[index] < heap[parent]){
            //fix below
            fixHeapBelow(index, size-1);
        }else{
            fixHeapAbove(index);
        }

        size--;
        return deletedValue;
    }

    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        return heap[0];
    }

    public void sort(){
        int lastHeapIndex = size-1; //assign lastHeapIndex to last index

        //iterate
        for(int i=0; i<lastHeapIndex; i++){
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = temp;
            //swap with 0 and last heap index

            //heapify the heap - start at root -- end at exclude where we put root
            fixHeapBelow(0, lastHeapIndex - i-1);
        }
    }

    public void printHeap(){
        System.out.print("Heap : ");
        for(int i=0; i<size; i++){
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }
};


public class Heaps {

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        System.out.println("Deleted element at index 1");
        heap.delete(1);
        heap.printHeap();
        System.out.println(heap.peek());
        heap.sort();
        heap.printHeap();

    }
}
