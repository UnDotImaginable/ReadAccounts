import java.io.PrintWriter;


public abstract class BankAccount {

	private String owner = " ";
	private int number = 0;
	private double balance = 0;

	BankAccount() {
		
	}

	BankAccount(String owner, int number, double balance) {
		this.owner = owner;
		this.number = number;
		this.balance = balance;
		
		
	}
	
	public void printBankAccount() {
		System.out.println("\tOwner: " + owner);
		System.out.print("\tNumber: " + number + "\n");
		System.out.print("\tBalance: " + balance + "\n");

	}
	
	public int getNumber() {
		return number;
	}
	
	public void printBankAccount(PrintWriter pw) { 
		pw.print(owner + ",");
		pw.print(number + ",");
		pw.print(balance);

	}
}
