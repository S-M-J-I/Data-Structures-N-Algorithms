package algorithms.greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffmanEncoding {

    static class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{
        char data;
        int frequency;
        HuffmanTreeNode left, right;

        public HuffmanTreeNode(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            this.left = this.right = null;
        }

        @Override
        public int compareTo(HuffmanTreeNode o) {
            return Double.compare(this.frequency, o.frequency);
        }
    }

    public static void main(String[] args) {
        ArrayList<HuffmanTreeNode> nodes = new ArrayList<>();

        char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        int[] freq = { 40, 10, 18, 20, 17, 25, 24, 35, 21 };

        for(int i = 0; i < arr.length; ++i) {
            nodes.add(new HuffmanTreeNode(arr[i], freq[i]));
        }

        HuffmanEncode(nodes);
    }

    private static void code(HuffmanTreeNode root, String string) {
        if(root == null) {
            return;
        }

        if(root.data != '#') {
            System.out.println(root.data + ": " + string);
        }

        code(root.left, string.concat("0"));
        code(root.right, string.concat("1"));
    }

    private static void HuffmanEncode(ArrayList<HuffmanTreeNode> nodes) {

        PriorityQueue<HuffmanTreeNode> minHeap = new PriorityQueue<>(nodes);


        while (minHeap.size() > 1) {
            HuffmanTreeNode left = minHeap.remove();
            HuffmanTreeNode right = minHeap.remove();

            HuffmanTreeNode root = new HuffmanTreeNode('#', (left.frequency + right.frequency));

            root.left = left;
            root.right = right;

            minHeap.add(root);
        }

        code(minHeap.peek(), "");
    }
}
