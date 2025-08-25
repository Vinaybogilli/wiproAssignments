import java.util.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        ArrayDeque<String> aq = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String s = sc.nextLine();

            if (aq.size() < 3) {
                aq.addLast(s);
            } else {
                aq.removeFirst();  
                aq.addLast(s);
            }

            
        }
        System.out.println(aq);

        sc.close();  
    }
}
