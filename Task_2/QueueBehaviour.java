package Task_2;

public interface QueueBehaviour<T> {
    public void Enqueue(T element);

    public T FirstOne();

    public void Dequeue(T element);
}