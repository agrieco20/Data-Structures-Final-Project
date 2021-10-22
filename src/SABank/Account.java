/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SABank;

/**
 * @author Anthony Grieco, Matthew O'Hara, Zachary Phillips
 */
import java.util.Random;

public class Account {
    private String firstName;
    private String lastName;
    private char sex;
    private String dob;
    private String ssn;
    private String accountNumber;
    private char accountType;
    private int person;
    private double balance;

    public Account(String nameFirst, String nameLast, char gender, String birthday, char typeOfAccount, int personType){
        firstName = nameFirst;
        lastName = nameLast;
        sex = gender;
        dob = birthday;
        ssn = generateSSN();
        accountNumber = generateAccountNum();
        accountType = typeOfAccount;
        person = personType;
        balance = 0;
    }

    public Account(String nameFirst, String nameLast, char gender, String birthday, char typeOfAccount, int personType, double balanceAmt){
        //public Account(String nameFirst, String nameLast, char gender, String birthday, String socialSecurityNum, String accountNum, char typeOfAccount, int personType, double balanceAmt){
        firstName = nameFirst;
        lastName = nameLast;
        sex = gender;
        dob = birthday;
        ssn = generateSSN();
        accountNumber = generateAccountNum();
        accountType = typeOfAccount;
        person = personType;
        balance = balanceAmt;
    }

    public void setFirstName(String nameFirst){
        firstName = nameFirst;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String nameLast){
        firstName = nameLast;
    }

    public String getLastName(){
        return lastName;
    }

    public void setGender(char gender){
        sex = gender;
    }

    public char getGender(){
        return sex;
    }

    public void setBirthday(String birthday){
        dob = birthday;
    }

    public String getBirthday(){
        return dob;
    }
    //-----------------------
//    Random generator = new Random();
//
//        String SSN = "";
//
//        for (int i = 0; i < 9; i++){
//            SSN += generator.nextInt(10);
//        }
//        System.out.println(generateSSN());
//        System.out.println(generateAccNum());

    private String generateSSN(){
        Random generator = new Random();
        String SSN = "";
        for (int i = 0; i < 9; i++){
            SSN += generator.nextInt(10);
        }
        return SSN;
    }

    public String getHiddenSSN(){ //New
        String hiddenSSN = "***-**-";
        for (int i = 5; i<ssn.length(); i++){
            hiddenSSN += ssn.charAt(i);
        }
        return hiddenSSN; //Need to block the first 5 digits with '*'
    }

    private String generateAccountNum(){
        Random generator = new Random();
        String accountNumber = "";
        for (int i = 0; i < 5; i++){
            accountNumber += generator.nextInt(10);
        }
        return accountNumber;
    }
    //-----------------------

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountType(char typeOfAccount){
        accountType = typeOfAccount;
    }

    public char getAccountType(){
        return accountType;
    }

    public void setPersonType(char personType){
        person = personType;
    }

    public int getPersonType(){
        return person;
    }

    public void setInitialBalance(double balanceAmt){
        balance = balanceAmt;
    }

    public void depositToBalance(double depositAmt){
        balance+=depositAmt;
    }

    public void withdrawFromBalance(double withdrawAmt){
        balance-=withdrawAmt;
    }

    public double getBalance(){
        return balance;
    }

    public String displayAllAccountInfo(){
        //"First Name" + " " + "Last Name" + " " + "Gender" + " " + "Birthday" + " " + "Social Security Number" + " " + "Account Number" + " " + "Account Type"+ " " + "Person Type" + " " + "Balance";
        return firstName + " " + lastName + " " + sex + " " + dob + " " + getHiddenSSN() + " " + accountNumber + " " + accountType + " " + person + " $" + String.format("%.2f", balance);
    }

}
