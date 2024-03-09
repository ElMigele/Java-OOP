package Task_4.T_1;

public class Pair<T, U> {
    private T first;
    public T getFirst(){
        return first;
    }
    public void setFirst(T e){
        first = e;
    }

    private U second;
    public U getSecond(){
        return second;
    }
    public void setSecond(U e){
        second = e;
    }
    
    
    public Pair(T e1, U e2){
        first = e1;
        second = e2;
    }

    @Override
    public String toString(){
        return "Pair: " + first + " | " + second;
    }
}