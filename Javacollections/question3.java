import java.util.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Stack<String> s = new Stack<>();
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<3;i++){
            String l=sc.nextLine();
            s.push(l);
        }
        System.out.println("Your stack before function is:"+s);
        Stack<String>newstack=new Stack();
       
       
        while(!s.isEmpty()){
            newstack.push(s.peek());
            s.pop();
        }
        
        System.out.println("Your stack After function is:"+newstack);
        sc.close();  
    }
}
