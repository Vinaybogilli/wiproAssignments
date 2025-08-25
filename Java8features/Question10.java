import java.util.*;
import java.util.stream.*;

public class Question10 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob", "Alice");

        Map<String, Long> nameCounts = names.stream()
                                            .collect(Collectors.groupingBy(
                                                name -> name,
                                                Collectors.counting()
                                            ));

        System.out.println(nameCounts);
    }
}
