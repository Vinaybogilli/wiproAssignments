import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Vinay");
        names.add("Arjun");
        names.add("Bhavana");
        names.add("Kiran");
        names.add("Divya");

        names.sort((s1, s2) -> s1.compareTo(s2));

        for (String name : names) {
            System.out.println(name);
        }
    }
}
