// ...existing code...
public class BankAccount {
    private String accountNumber;
    private String accountName;
    private double balance;
    private int pinNumber;

    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String accountName, double balance, int pinNumber) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.pinNumber = pinNumber;
        totalAccounts++;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pinNumber;
    }

     public boolean setPin(int pin){
        if (pin >= 1000 && pin <= 9999){
            this.pinNumber = pin;
            TablePrinter.printAccountTable("Set PIN", accountNumber, accountName, balance, String.valueOf(pin));
            return true;
        }else{
            System.out.println("Pin is Invalid! Pin must be a 4-digit number.");
            return false;
        }
    }

    public void deposit(double amount) {
        if (amount > 0 ) {
            this.balance += amount;
            TablePrinter.printTransactionTable("DEPOSIT", amount, balance);
        } else {
            System.out.println("Deposit amount must not be below zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            TablePrinter.printTransactionTable("WITHDRAW", amount, balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }


}