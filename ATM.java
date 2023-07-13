import java.util.*;
public class ATM {

	String username;
	String password;
	String name;
	String accNo;
	float balance=0;
	int noOfTransactions=0;
	String transactionHistory="";
	
	public void createAccount() {
		Scanner in = new Scanner(System.in);
        System.out.println("*************************");
		System.out.println("Enter your name: ");
		this.name=in.nextLine();
		System.out.println("Enter Account Number: ");
		this.accNo=in.nextLine();
		System.out.println("Enter your username");
		this.username=in.nextLine();
		System.out.println("Enter password");
		this.password=in.nextLine();
		System.out.println();
		System.out.println("Your registration is successfully completed\n");
        System.out.println("*************************");
	}
	public void login() {
		boolean flag=true;
		Scanner in = new Scanner(System.in);
		while(flag) {
            
			System.out.println("Enter your username :");
			String Username=in.nextLine();
			if(Username.equals(username)) {
				System.out.println("Enter password");
				String Password=in.nextLine();
				if(Password.equals(password)) {
					System.out.println("Login successful");
                    
					flag=false;
				}
				else
					System.out.println("Password doesn't match, Please try again ");	
                    
			}
			else {
				System.out.println("\n Username Not Found");
                
			}
		}
	}
	public void deposit() {
        System.out.println("*************************");
		System.out.println("Enter amount to deposit,amount should be greater than zero:");
		Scanner in = new Scanner(System.in);
		float amount=in.nextFloat();
		balance=balance+amount;
		System.out.println("Amount "+amount+" has been deposited");
		noOfTransactions++;
		String transaction = amount+" has been credited to your account\n";
		transactionHistory = transactionHistory.concat(transaction);
        System.out.println("*************************");
	}
	public void withdraw() {
        System.out.println("*************************");
		System.out.println("Enter amount to withdraw ");
		Scanner in = new Scanner(System.in);
		float amount=in.nextFloat();
		if(balance>=amount) {
			balance =balance-amount;
			System.out.println(amount +" Withdrawl succesul");
			noOfTransactions++;
			String transaction = amount+" has been successfully withdrawn\n";
            
			transactionHistory = transactionHistory.concat(transaction);
		}
		else
			System.out.println("Insufficient Balance ");
            System.out.println("*************************");
	}
	public void transfer() {
		Scanner in = new Scanner(System.in);
        
		System.out.println("\nEnter Receiver's Name : ");
		String receiver=in.nextLine();
		System.out.println("\nEnter Amount to transfer : ");
		float amount = in.nextFloat();
		if(amount<=balance) {
			balance = balance-amount;
			System.out.println(amount+" successfully transferred ");
			noOfTransactions++;
			String transaction = amount+" transferred to "+receiver+"\n";
			transactionHistory = transactionHistory.concat(transaction);
		}
        System.out.println("*************************");
	}
	public void balanceEnquiry() {
		System.out.println("Your account balance is "+balance);
        System.out.println("*************************");
	}
	public void transactionHistory() {
		System.out.println("\n"+transactionHistory);
        System.out.println("*************************");
	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        System.out.println("*************************");
		System.out.println("WELCOME TO ATM INTERFACE\n");
		System.out.println(" Enter 1-> Create account\n Enter 0 -> exit\n");
		System.out.println("Enter your choice");
		int input=in.nextInt();
		if(input==1) {
			ATM user = new ATM();
			user.createAccount();
			System.out.println("\nplease enter atm details to login\n");
			user.login();
			boolean exit=false;
			while(!exit) {
				System.out.println("\n1.Deposit \n2.withdraw \n3.Trasfer \n4.check balance \n5.check transactions \n6.Exit\n");
				System.out.println("Enter your choice");
				int choice = in.nextInt();
				if(choice<7 && choice>0) {
					switch(choice) {
					case 1:user.deposit();
							break;
					case 2:user.withdraw();
							break;
					case 3:user.transfer();
							break;
					case 4:user.balanceEnquiry();
							break;
					case 5:user.transactionHistory();
							break;
					case 6:exit=true;
							break;
					
					}
				}
			}
		}
	}
}
