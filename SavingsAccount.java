import java.io.PrintWriter;

public class SavingsAccount extends BankAccount {
	
	private String owner = " ";
	private int number = 0;
	private double balance = 0;
	private double interest = 0;
	
	
	SavingsAccount() {
		
	}
	
	SavingsAccount(String owner, int number, double balance, double interest) {
		super(owner, number, balance);
		this.interest = interest;
		
	}
	
	public void printBankAccount() {
		super.printBankAccount();
		System.out.print("\tInterest rate: " + interest);
	}
	
	public int getNumber() {
		return super.getNumber();
	}
	
	public void printBankAccount(PrintWriter pw) {
		super.printBankAccount(pw);
		pw.print("," + interest + "\n");
	}
}
