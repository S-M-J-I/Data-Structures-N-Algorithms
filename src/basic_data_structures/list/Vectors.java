package basic_data_structures.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class CustomVector<T extends Object> {
    List<T> list;
    private int size;

    public CustomVector() {
        list = new ArrayList<>();
    }

    public void push_back(T item) {
        list.add(item);
        size++;
    }

    public void pop_back() {
        list.remove(size-1);
        size--;
    }

    public void push_front(T item) {
        list.add(0, item);
        size++;
    }

    public void pop_front() {
        list.remove(0);
        size--;
    }

    public void removeOccurrencesOf(T item) {
        this.list.removeIf((i) -> i.equals(item));
    }

    public void show() {
        for(T item : this.list) {
            System.out.print(item+" ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}

public class Vectors {

    public static void main(String[] args) {
        CustomVector<String> customVector = new CustomVector<>();

        customVector.push_front("a");
        customVector.push_front("b");
        customVector.push_front("c");
        customVector.show();
        customVector.pop_front();
        customVector.pop_back();
        customVector.show();

        for(int i = 0; i < 10; ++i) {
            customVector.push_back("c");
        }
        customVector.show();
        customVector.removeOccurrencesOf("c");
        customVector.show();
    }
}
