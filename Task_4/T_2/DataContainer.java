package Task_4.T_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataContainer<T> implements Iterable<T>{
    private List<T> elements;
    
    public DataContainer(){
        elements = new ArrayList<T>();
    }

    public void Add(T item){
        elements.add(item);
    }

    public T Get(int index){
        if (index < 0 || index >= elements.size()){
            throw new UnsupportedOperationException("index out of range");
        }
        return elements.get(index);
    }

    public void Remove(int index){
        if (index < 0 || index >= elements.size()){
            return;
        }
        elements.remove(index);
    }

    public int GetSize(){
        return elements.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyDataContainerIterator();
    }

    @Override
    public String toString(){
        String res = new String();
        for (int i = 0; i < elements.size(); i++){
            res += i + ": " + elements.get(i) +"\n";
        }
        return res;
    }

    private class MyDataContainerIterator implements Iterator<T> {
        int id = 0;
        @Override
        public boolean hasNext() {
            return id < elements.size();
        }

        @Override
        public T next() {
            return elements.get(id++);
        }
    }
}