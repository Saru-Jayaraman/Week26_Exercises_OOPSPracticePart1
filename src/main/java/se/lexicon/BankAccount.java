package se.lexicon;

public class BankAccount {
    private String accountNumber;
    private String customerName;
    private String phoneNumber;
    private String email;
    private double balance;
    public double MIN_BALANCE_AMOUNT = 500;
    BankAccount() {
        System.out.println("Default constructor");
    }

    BankAccount(String accountNumber, String customerName, String phoneNumber, String email, double balance) {
        this();
        setAccountNumber(accountNumber);
        setCustomerName(customerName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setBalance(balance);
    }

    public String getAccountNumber() {
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

    public void setAccountNumber(String accountNumber) {
        validateBankAccountParams(accountNumber, "Account Number");
        this.accountNumber = accountNumber;
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
        System.out.println("Account Number: " + accountNumber + " Customer Name: " + customerName +
                " Phone Number: " + phoneNumber + " Email: " + email + " Balance: " + balance);
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