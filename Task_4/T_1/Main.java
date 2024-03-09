package Task_4.T_1;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<String,Integer>("one", 1);
        System.out.println(pair);
        pair.setFirst("two");
        System.out.println(pair);
        pair.setSecond(3);
        System.out.println(pair);
    }
}