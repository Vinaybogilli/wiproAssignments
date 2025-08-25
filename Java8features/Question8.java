import java.util.*;
import java.util.stream.*;

public class Question8 {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Mumbai", "Delhi", "Chennai", "Kolkata", "Bangalore");

        String result = cities.stream()
                              .collect(Collectors.joining());

        System.out.println(result);
    }
}
