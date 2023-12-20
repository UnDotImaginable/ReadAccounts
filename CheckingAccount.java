import java.io.PrintWriter;

public class CheckingAccount extends BankAccount {
	
	private String owner = " ";
	private int number = 0;
	private double balance = 0;
	private int checkLimit = 0;
	
	CheckingAccount() {
		
	}
	
	CheckingAccount(String owner, int number, double balance, int checkLimit) {
		super(owner, number, balance);
		this.checkLimit = checkLimit;
	}
	
	public void printBankAccount() {
		super.printBankAccount();
		System.out.print("\tCheck limit: " + checkLimit);
	}
	
	public int getNumber() {
		return super.getNumber();
	}
	
	public void printBankAccount(PrintWriter pw) {
		super.printBankAccount(pw);
		pw.print("," + checkLimit + "\n");

	}
	
	
}
