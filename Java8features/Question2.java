import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Question2 {
    public static void main(String[] args) {
        BiFunction<Double, Double, Optional<Double>> divide = (a, b) ->
                b == 0 ? Optional.empty() : Optional.of(a / b);

        Consumer<Optional<Double>> handleResult = result ->
                result.ifPresentOrElse(
                        r -> System.out.println("Result: " + r),
                        () -> System.out.println("Division by zero is not allowed")
                );

        handleResult.accept(divide.apply(10.0, 2.0));
        handleResult.accept(divide.apply(10.0, 0.0));
    }
}
