import java.util.*;
import java.util.stream.*;

public class Question5 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "anna", "mike", "arun");

        List<String> filtered = names.stream()
                                     .filter(name -> name.startsWith("a"))
                                     .collect(Collectors.toList());

        System.out.println(filtered);
    }
}
