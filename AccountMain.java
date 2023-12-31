public class GaudaniCIS265Assignment7 {
	public static void main(String[] args) throws IOException {
		

		String userInput = args[0];
		String output = args[1];
		
		
		File InputFile = new File(userInput);
		
		Scanner scan = new Scanner(InputFile);
		
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
			
		while(scan.hasNextLine()) {
			
			String[] eachWord = scan.nextLine().split(",");
			// x % 1 == 0 to test if number is int or double
			
			boolean isString = false;
			boolean isInt = false;
			boolean isDouble = false;
			boolean isString2 = false;
			boolean isInt2 = false;
			boolean isDouble2 = false;
			
			
			if (eachWord.length == 5) {
				if (isOnlyAString(eachWord[0])) 
					isString = true;
				
				if (isNumAndInteger(eachWord[1])) 
					isInt = true;
				
				if (isNumAndDouble(eachWord[2])) 
					isDouble = true;
				
				if (isOnlyAString(eachWord[3])) {
					isString2 = true;
					
					if (eachWord[3].equals("checking")) {
						if (isNumAndInteger(eachWord[4]))
							isInt2 = true;
					}	
					
					if (eachWord[3].equals("savings")) {
						if (isNumAndDouble(eachWord[4]))
							isDouble2 = true;
						
					}
				}
			}
			else {
				break;
			}
			
			try {
			if ((eachWord.length == 5) && (isString && isInt && isDouble
					&& isString2 && isInt2 && !isDouble2)) {
				accounts.add(new CheckingAccount(eachWord[0], 
						Integer.parseInt(eachWord[1]), 
						Double.parseDouble(eachWord[2]), 
						Integer.parseInt(eachWord[4])));
			}
			
			if ((eachWord.length == 5) && (isString && isInt && isDouble
					&& isString2 && isDouble2 && !isInt2)) {
				accounts.add(new SavingsAccount(eachWord[0], 
						Integer.parseInt(eachWord[1]), 
						Double.parseDouble(eachWord[2]), 
						Double.parseDouble(eachWord[4])));
			}
			}
			catch(NumberFormatException e) {
				break;
			}
			
			
		}
		
		AccountNumberComparator ancomp = new AccountNumberComparator();
		Collections.sort(accounts, ancomp);
		
		PrintWriter write = new PrintWriter(output);
		 for (int i = 0; i <= accounts.size() - 1; i++) {
			accounts.get(i).printBankAccount(write);
			 
		 }
		 
		 
		 write.flush();
		 write.close();
		
		 
	
			
		}
	
	public static boolean isOnlyAString(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) == false) {
				return true;
			}
			
	}
		
		return false;
	}
	
	public static boolean isNumAndInteger(String s) {
		boolean isNum = true;
		
		try {
			double num = Double.parseDouble(s);
		}
		catch(NumberFormatException e) {
			isNum = false;
		}
		// if its a number
		if (isNum) {
			if (Double.parseDouble(s) % 1 == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isNumAndDouble(String s) {
		boolean isNum = true;
		
		try {
			double num = Double.parseDouble(s);
		}
		catch(NumberFormatException e) {
			isNum = false;
		}
		// if its a number
		if (isNum) {
			if (Double.parseDouble(s) % 1 != 0) {
				return true;
			}
			else if (Double.parseDouble(s) == 1.0) {
				return true;
			}
		}
		
		return false;
	}
}
	
