interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

interface Faxable {
    void fax();
}


class BasicPrinter implements Printable {
 public void print() {
     System.out.println("Basic printing");
 }
}

class MultiFunctionPrinter implements Printable, Scannable {
 public void print() {
     System.out.println("Multifunction: Printing...");
 }

 public void scan() {
     System.out.println("Multifunction: Scanning...");
 }
}


public class interfacesegregation {

	public static void main(String[] args) {
		 Printable basic = new BasicPrinter();
	        basic.print();
	        
	        MultiFunctionPrinter multi = new MultiFunctionPrinter();
	        multi.print();
	        multi.scan();

	}

}
