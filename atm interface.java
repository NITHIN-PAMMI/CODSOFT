import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited: $%.2f\n", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew: $%.2f\n", amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
            return false;
        } else {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
    }
}
class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("THANK YOU.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
    private void checkBalance() {
        System.out.printf("Current balance: $%.2f\n", account.getBalance());
    }
    private void deposit(double amount) {
        account.deposit(amount);
    }
    private void withdraw(double amount) {
        account.withdraw(amount);
    }
}
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00);
                ATM atm = new ATM(userAccount);
                atm.displayMenu();
    }
}

