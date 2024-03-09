package Task_4.T_2;

public class Main {
    public static void main(String[] args) {
        DataContainer<String> d = new DataContainer<>();
        d.Add("First");
        d.Add("Second");
        d.Add("First");
        
        System.out.println("After Addition:");
        System.out.println(d);

        System.out.println("Container Size:");
        System.out.println(d.GetSize());

        System.out.println("First element:");
        System.out.println(d.Get(0));

        System.out.println("After Remove First element:");
        d.Remove(0);
        System.out.println(d);
    }
}