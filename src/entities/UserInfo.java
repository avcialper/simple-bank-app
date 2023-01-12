package entities;

public class UserInfo {
    
    private String name;
    private String surname; 
    private String email;
    private int password;
    private int idNumber;
    private int ibanNumber;
    private int accountNumber;
    private double tlBalance;
    private double dolarBalance;
    private double euroBalance;

    public UserInfo(int idNumber, String name, String surname, int password, double tlBalance,
            double dolarBalance, double euroBalance, int ibanNumber, int accountNumber, String email) {
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.tlBalance = tlBalance;
        this.dolarBalance = dolarBalance;
        this.euroBalance = euroBalance;
        this.ibanNumber = ibanNumber;
        this.accountNumber = accountNumber;
        this.email = email;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getTlBalance() {
        return tlBalance;
    }

    public void setTlBalance(double tlBalance) {
        this.tlBalance = tlBalance;
    }

    public double getDolarBalance() {
        return dolarBalance;
    }

    public void setDolarBalance(double dolarBalance) {
        this.dolarBalance = dolarBalance;
    }

    public double getEuroBalance() {
        return euroBalance;
    }

    public void setEuroBalance(double euroBalance) {
        this.euroBalance = euroBalance;
    }

    public int getIbanNumber() {
        return ibanNumber;
    }

    public void setIban(int ibanNumber) {
        this.ibanNumber = ibanNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
