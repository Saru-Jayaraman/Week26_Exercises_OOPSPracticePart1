package se.lexicon;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BankAccount obj1 = new BankAccount(56107829, "Sarumathi Jayaraman",
                "7708489028", "sarumathijayaraman@gmail.com", 10000);
        obj1.displayBankAccountDetails();
        BankAccount obj2 = new BankAccount("Pragya Satheeshkumar",
                "7703464325", "pragyasatheeshkumar@gmail.com", 5000);
        obj2.displayBankAccountDetails();
        BankAccount obj3 = new BankAccount("Satheeshkumar Chandran",
                "7703445678", "satheeshkumarchandran@gmail.com", 15000);
        obj3.displayBankAccountDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount to deposit to " + obj1.getCustomerName() + " account:");
        double depositAmt1 = scanner.nextDouble();
        obj1.depositAmount(depositAmt1);
        System.out.println(obj1.getBalance());

        System.out.println("Enter amount to deposit to " + obj2.getCustomerName() + " account:");
        double depositAmt2 = scanner.nextDouble();
        obj2.depositAmount(depositAmt2);
        System.out.println(obj2.getBalance());

        System.out.println("Enter amount to deposit to " + obj1.getCustomerName() + " account:");
        double withdrawAmt1 = scanner.nextDouble();
        String withdrawnMessage1 = obj1.withdrawAmount(withdrawAmt1);
        System.out.println(withdrawnMessage1);

        System.out.println("Enter amount to deposit to " + obj2.getCustomerName() + " account:");
        double withdrawAmt2 = scanner.nextDouble();
        String withdrawnMessage2 = obj2.withdrawAmount(withdrawAmt2);
        System.out.println(withdrawnMessage2);
    }
}