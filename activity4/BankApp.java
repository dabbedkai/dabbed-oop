package activity4;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class BankApp {

    public static void loadAccounts(ArrayList<BankAccount> accounts) {

        try (Scanner reader = new Scanner(new File("accounts.csv"))) {
            reader.nextLine();
            // read each line and split by comma
            while (reader.hasNextLine()) {
                String[] cols = reader.nextLine().split(",");
                String acctNo = cols[0];
                String fullName = cols[1];
                float balance = Float.parseFloat(cols[2]);
                int pin = Integer.parseInt(cols[3]);

                // create bank account object and add to list
                BankAccount acc = new BankAccount(acctNo, fullName, balance, pin);
                accounts.add(acc);
            }
        } catch (FileNotFoundException e) {
            // handle file not found exception
            e.printStackTrace();
        }
    }

    public static void depositAccount(ArrayList<BankAccount> accounts, Scanner sc) {
        System.out.print("ENTER ACCOUNT NUMBER: ");
        String accountNumber = sc.nextLine();

        BankAccount account = findAccount(accounts, accountNumber);
        if (account != null) {
            System.out.print("ENTER AMOUNT TO DEPOSIT: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            account.deposit(amount);
        } else {
            System.out.println("ACCOUNT NOT FOUND! PLEASE CHECK THE ACCOUNT NUMBER AND TRY AGAIN.");
        }
    }

    public static void withdrawAccount(ArrayList<BankAccount> accounts, Scanner sc) {
        System.out.print("ENTER ACCOUNT NUMBER: ");
        String accountNumber = sc.nextLine();

        BankAccount account = findAccount(accounts, accountNumber);

        if (account != null) {
            System.out.print("ENTER AMOUNT TO WITHDRAW: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            account.withdraw(amount);
        } else {
            System.out.println("ACCOUNT NOT FOUND! PLEASE CHECK THE ACCOUNT NUMBER AND TRY AGAIN.");
        }
    }

    public static BankAccount findAccount(ArrayList<BankAccount> accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        File file = new File("accounts.csv");

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        loadAccounts(accounts);

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. CREATE NEW ACCOUNT");
            System.out.println("2. VIEW ACCOUNTS");
            System.out.println("3. DEPOSIT");
            System.out.println("4. WITHDRAW");
            System.out.println("5. EXIT");
            System.out.print("CHOOSE AN OPTION: ");

            String userInput = sc.nextLine();

            switch (userInput) {
                case "1":
                    System.out.print("ENTER ACCOUNT NUMBER: ");
                    String accountNumber = sc.nextLine();

                    System.out.print("ENTER ACCOUNT NAME: ");
                    String accountName = sc.nextLine();

                    System.out.print("ENTER INITIAL BALANCE: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("SET A 4-DIGIT PIN: ");
                    int pinNumber = sc.nextInt();
                    sc.nextLine();

                    BankAccount newAccount = new BankAccount(accountNumber, accountName, balance, pinNumber);
                    accounts.add(newAccount);
                    System.out.println("ACCOUNT CREATED SUCCESSFULLY!");
                    break;

                case "2":
                    System.out.println("\n--- YOUR ACCOUNTS ---");
                    if (accounts.isEmpty()) {
                        System.out.println("NO ACCOUNTS FOUND, CREATE AN ACCOUNT!");
                    } else {
                        for (BankAccount account : accounts) {
                            System.out.println("Account Number: " + account.getAccountNumber() + ", Account Name: "
                                    + account.getAccountName() + ", Balance: $" + account.getBalance());
                        }
                    }
                    break;

                case "3":
                    depositAccount(accounts, sc);
                    break;

                case "4":
                    withdrawAccount(accounts, sc);
                    break;

                case "5":
                    isRunning = false;
                    try{
                        FileOutputStream fos = new FileOutputStream(file);
                        String header = "Account Number,Account Name,Balance,Pin\n";
                        fos.write(header.getBytes());

                        for (BankAccount account : accounts) {
                            String line = account.getAccountNumber() + "," + account.getAccountName() + ","
                            + account.getBalance() + "," + account.getPin() + "\n";
                            fos.write(line.getBytes());
                        }
                        System.out.println("THANK YOU FOR USING THE BANK APP. GOODBYE!");
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("INVALID OPTION! PLEASE CHOOSE A VALID OPTION.");
            }
        }
        sc.close();
    }
}
