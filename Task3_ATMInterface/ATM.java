
import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Invalid amount or insufficient balance!");
        }
    }

    public void deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs. "
                + account.checkBalance());
    }

    public void start() {

        int choice;

        do {
            System.out.println("\n===== ATM INTERFACE =====");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine();

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option!");
                choice = 0;
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    processWithdrawal();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    processDeposit();
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);
    }

    private void processWithdrawal() {
        try {
            double amount = Double.parseDouble(sc.nextLine());

            if (!Double.isFinite(amount)) {
                System.out.println("Please enter a valid amount!");
            } else {
                withdraw(amount);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount!");
        }
    }

    private void processDeposit() {
        try {
            double amount = Double.parseDouble(sc.nextLine());

            if (!Double.isFinite(amount)) {
                System.out.println("Please enter a valid amount!");
            } else {
                deposit(amount);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount!");
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount(5000);

        ATM atm = new ATM(account);

        atm.start();
    }
}