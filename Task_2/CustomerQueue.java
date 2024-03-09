package Task_2;

import java.util.Queue;

public class CustomerQueue<T> implements QueueBehaviour<T>{
    public Queue<T> Queue;

    @Override
    public void Enqueue(T element) {
        Queue.add(element);
    }

    @Override
    public T FirstOne() {
        return Queue.peek();
    }

    @Override
    public void Dequeue(T element) {
        Queue.remove();
    }

    public void Status(){
        String st = Queue.size() != 0
        ? "Customers in queue: " + Queue.size()
        : "No customers";
        System.out.println(st);
    }
}