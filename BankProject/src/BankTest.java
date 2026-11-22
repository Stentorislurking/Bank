public class BankTest {
    public static void main(String[] args) {
        System.out.println("--- Test 1: BankAccount ---");
        BankAccount basic = new BankAccount("Maria", "Lopez", 1001);
        basic.deposit(500);
        basic.withdrawal(200);
        basic.withdrawal(1000);
        basic.accountSummary();

        System.out.println();
        System.out.println("--- Test 2: CheckingAccount, normal withdrawal ---");
        CheckingAccount checking = new CheckingAccount("James", "Carter", 2002, 1.5);
        checking.deposit(100);
        checking.processWithdrawal(40);
        checking.displayAccount();

        System.out.println();
        System.out.println("--- Test 3: CheckingAccount, overdraft withdrawal ---");
        checking.processWithdrawal(400);
        checking.displayAccount();

        System.out.println();
        System.out.println("--- Test 4: Invalid amounts and setters ---");
        checking.deposit(-25);
        checking.processWithdrawal(0);
        checking.setFirstName("Jim");
        checking.setLastName("Carter Jr.");
        checking.setAccountID(2003);
        checking.displayAccount();
    }
}