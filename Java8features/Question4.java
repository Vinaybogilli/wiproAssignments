@FunctionalInterface
interface MyInterface {
    void abstractMethod(); 

    default void defaultMethod() {
        System.out.println("This is a default method.");
    }
}

public class Question4 {
    public static void main(String[] args) {
        MyInterface obj = () -> System.out.println("Abstract method implemented.");
        obj.abstractMethod();
        obj.defaultMethod();
    }
}
