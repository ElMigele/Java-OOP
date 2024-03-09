package Task_3.Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MyLinkedList implements Iterable<Integer>{
    private List<Integer> elements;

    public MyLinkedList(int size){
        Random r = new Random();
        elements = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) {
            elements.add(r.nextInt(0, 100));
        }
    }

    public void Add(int element){
        elements.add(element);
    }

    public void Remove(int id) {
        if (id < 0 || id >= elements.size()){
            return;
        }
        elements.remove(id);
    }
    public int Get(int id) {
        if (id < 0 || id >= elements.size()){
            throw new UnsupportedOperationException("id is out of range");
        }
        return elements.get(id);
    }

    @Override
    public String toString(){
        String res = new String();
        int id = 0;
        for (Integer integer : elements) {
            res += id + ": "+ integer + "\n";
            id++;
        }
        return res;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyLinkedListIterator();
    }
    
    private class MyLinkedListIterator implements Iterator<Integer>{
        private int id = 0;

        @Override
        public boolean hasNext() {
            return id < elements.size();
        }

        @Override
        public Integer next() {
            return elements.get(id++);
        }
    }
}