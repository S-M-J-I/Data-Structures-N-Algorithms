package basic_data_structures.heaps;

import java.util.PriorityQueue;

public class PriorityQueueExamples {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);
        

        System.out.println(pq.peek());
        pq.remove();
        System.out.println(pq.peek());

        Object[] ints = pq.toArray();
        for(Object num : ints){
            System.out.print(num + " ");
        }

    }

}
