import java.util.*;
import java.util.stream.*;

public class Question12 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ravi", "Anita", "Suresh", "Aruna", "Bala");

        List<String> sortedNames = names.stream()
                                        .sorted(String::compareTo)
                                        .collect(Collectors.toList());

        System.out.println(sortedNames);
    }
}
