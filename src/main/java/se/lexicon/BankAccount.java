package se.lexicon;

public class BankAccount {
    private static final int accountNumberCounter = 1;
    private static long lastSetAccountNumber;
    private long accountNumber;
    private String customerName;
    private String phoneNumber;
    private String email;
    private double balance;
    public double MIN_BALANCE_AMOUNT = 500;
    BankAccount() {
        System.out.println("Default constructor");
    }

    BankAccount(String customerName, String phoneNumber, String email, double balance) {
        this.accountNumber = lastSetAccountNumber + accountNumberCounter;
        //Setting the last account number to static variable
        lastSetAccountNumber = accountNumber;
        setCustomerName(customerName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setBalance(balance);
    }

    BankAccount(long accountNumber, String customerName, String phoneNumber, String email, double balance) {
        this();
        setAccountNumber(accountNumber);
        setCustomerName(customerName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setBalance(balance);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(long accountNumber) {
        if(accountNumber <= 0 || String.valueOf(accountNumber).trim().isEmpty()) {
            throw new IllegalArgumentException("Account Number cannot zero/less than zero or empty...");
        }
        this.accountNumber = accountNumber;
        lastSetAccountNumber = accountNumber; //Setting the last account number to static variable
    }

    public void setCustomerName(String customerName) {
        validateBankAccountParams(customerName, "Customer Name");
        this.customerName = customerName;
    }

    public void setPhoneNumber(String phoneNumber) {
        validateBankAccountParams(phoneNumber, "Phone Number");
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        validateBankAccountParams(email, "Email");
        this.email = email;
    }

    public void setBalance(double balance) {
        validateBankAccountParams(String.valueOf(balance), "Balance");
        this.balance = balance;
    }

    public void validateBankAccountParams(String paramName, String paramFullName) {
        if(paramName == null || paramName.trim().isEmpty()) {
            throw new IllegalArgumentException(paramFullName + " is null or empty...");
        }
    }

    public void displayBankAccountDetails() {
        System.out.println("Account Number: " + getAccountNumber() + " Customer Name: " + getCustomerName() +
                " Phone Number: " + getPhoneNumber() + " Email: " + getEmail() + " Balance: " + getBalance());
    }

    public void depositAmount(double creditAmt) {
        balance = balance + creditAmt;
    }

    public String withdrawAmount(double debitAmt) {
        String withdrawnMessage;
        if((balance-debitAmt) >= MIN_BALANCE_AMOUNT) {
            balance = balance - debitAmt;
            withdrawnMessage = String.valueOf(balance);
        } else {
            withdrawnMessage = "Balance is insufficient to perform withdraw operation...";
        }
        return withdrawnMessage;
    }
}