import java.util.LinkedList;
import java.util.Scanner;
class Codechef {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 strings:");

        for (int i = 0; i < 5; i++) {
            String s = sc.nextLine();

            if (s.endsWith("!")) {
                
                s = s.substring(0, s.length() - 1);
            }

            
            s = "!" + s;

            list.add(s); 
        }

        System.out.println("\nFinal Output in Reverse Order:");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

        sc.close();
    }
}
