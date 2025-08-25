import java.util.*;
import java.util.stream.*;

public class Question6 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Jonathan", "Bob", "Catherine", "Arun");

        long count = names.stream()
                          .filter(name -> name.length() > 5)
                          .count();

        System.out.println("Count: " + count);
    }
}
