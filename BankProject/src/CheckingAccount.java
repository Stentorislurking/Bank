public class CheckingAccount extends BankAccount {
    private static final double OVERDRAFT_FEE = 30.0;
    private double interestRate;

    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void processWithdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal denied: amount must be greater than zero.");
            return;
        }

        if (amount > getBalance()) {
            balance -= amount + OVERDRAFT_FEE;
            System.out.printf("Overdraft fee of $%.2f has been assessed.%n", OVERDRAFT_FEE);
        } else {
            withdrawal(amount);
        }
        System.out.printf("New balance: $%.2f%n", getBalance());
    }

    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}