import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

class Codechef {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 strings:");

        for (int i = 0; i < 5; i++) {
            String s = sc.nextLine();
            list.add(s); 
        }

        System.out.println(list);
        Collections.reverse(list);
        
       System.out.println(String.join(", ", list));
        sc.close();
    }
}
