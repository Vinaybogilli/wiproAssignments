interface Paymentmethod
{
	void pay();
}

class creditcard implements Paymentmethod
{
	
	public void pay() {
		System.out.println("Process Creditcard Payment");
	}
}

class debitcard implements Paymentmethod
{
	
	public void pay() {
		System.out.println("Process debitcard Payment");
	}
}

class Processor
{
	void process(Paymentmethod payment) {
		payment.pay();
	}
}


public class openclosepriniciple {
	

	public static void main(String[] args) {
      Processor p1=new Processor();
      p1.process(new creditcard());
      p1.process(new debitcard());
	}

}
