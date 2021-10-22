package SABank;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 * @author Anthony Grieco, Matthew O'Hara, Zachary Phillips
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean quit = false;
        Scanner scan = new Scanner(System.in);
        final double interest = 0.02;
        int count = 0;
        boolean done=false;
        double withdrawal;
        Account Timmy = new Account("Timmy","Brown",'M',"07/04/01",'S',1,1000);
        Account Mark = new Account("Mark","Thompson",'M',"11/24/78",'C',2);
        Account Ellie = new Account("Ellie","Smith",'F',"05/09/70",'S',2,5000);
        Account Barry = new Account("Barry","Allen",'M',"03/14/68",'C',3);
        Account Amanda = new Account("Amanda","Turner",'F',"02/22/02",'S',1,1000);
        Account[] accountList = new Account[5];
        accountList[0]= Timmy;
        accountList[1]= Mark;
        accountList[2]= Ellie;
        accountList[3]= Barry;
        accountList[4]= Amanda;

        do{
            System.out.print("Welcome to the Saint Anselm Bank!\n"+"Please select one of the options below:\n");
            System.out.println("1. Display All Accounts\n"+"2. Make a Deposit\n"+"3. Make a Withdrawal\n"+"4. Add Interest to All Accounts\n"+"5. Total Number of Accounts\n"+"6. Exit");
            int answer = scan.nextInt();
            if(answer==1){
                //System.out.println("First Name," + " " + "Last Name," + " " + "Gender" + " " + "Birthday" + " " + "Social Security Number" + " " + "Account Number" + " " + "Account Type"+ " " + "Person Type" + " " + "Balance");
                for(Account elem : accountList){
                    System.out.println(elem.displayAllAccountInfo());
                }
            }
            if(answer==2){
                System.out.println("Which account would you like to deposit to? (Please enter last name of account)");
                scan.nextLine();
                String lastNameResponse = scan.nextLine();
                for(Account elem : accountList){
                    if(elem.getLastName().equalsIgnoreCase(lastNameResponse)){
                        System.out.println("Which account would you like to deposit to? (Please enter first name of account)");
                        String firstNameResponse = scan.nextLine();
                        if(elem.getFirstName().equalsIgnoreCase(firstNameResponse)){
                            System.out.print("How much would you like to deposit to that account?\n$");
                            double deposit = scan.nextDouble();
                            elem.depositToBalance(deposit);
                            System.out.println("The amount $"+String.format("%.2f",deposit)+" has been added to the account\n Current Balance: $"+ String.format("%.2f", elem.getBalance()));
                        }else{
                            count+=1;
                            if(count==accountList.length){
                                System.out.println("An account under that first name doesn't exist.");
                            }
                        }
                    }else{
                        count+=1;
                        if(count==accountList.length){
                            System.out.println("An account under that last name doesn't exist.");
                        }
                    }
                }
                count=0;

            }
            if(answer==3){
                System.out.println("Which account would you like to withdraw from? (Please enter last name of account)");
                scan.nextLine();
                String lastNameResponse = scan.nextLine();
                for(Account elem : accountList){
                    if(elem.getLastName().equalsIgnoreCase(lastNameResponse)){
                        System.out.println("Which account would you like to withdraw from? (Please enter first name of account)");
                        String firstNameResponse = scan.nextLine();
                        if(elem.getFirstName().equalsIgnoreCase(firstNameResponse)){
                            System.out.print("How much would you like to withdraw from that account?\n$");
                            withdrawal = scan.nextDouble();
                            while(done==false){

                                if(withdrawal>elem.getBalance()) {
                                    System.out.println("You do not have enough money make a withdrawal of that size.");
                                    done=false;
                                }else{
                                    elem.withdrawFromBalance(withdrawal);
                                    System.out.println("The amount $"+String.format("%.2f",withdrawal)+" has been removed to the account\n Current Balance: $"+ String.format("%.2f",elem.getBalance()));
                                    break;
                                }
                                System.out.println("How much would you like to withdraw from that account?");
                                withdrawal = scan.nextDouble();
                            }
//                            System.out.println("How much would you like to withdraw from that account?");
//                            double withdrawal = scan.nextDouble();
//                            if(withdrawal>elem.getBalance()){
//                                System.out.println("You do not have enough money make a withdrawal of that size");
//                            }else{
//                                elem.withdrawFromBalance(withdrawal);
//                                System.out.println("The amount $"+String.format("%.2f",withdrawal)+" has been removed to the account\n Current balance: "+ elem.getBalance());
                            //}
                        }else{
                            count+=1;
                            if(count==accountList.length){
                                System.out.println("An account under that first name doesn't exist.");
                            }
                        }
                    }else{
                        count+=1;
                        if(count==accountList.length){
                            System.out.println("An account under that last name doesn't exist.");
                        }
                    }
                }
                count=0;

            }
            if(answer==4){
                System.out.println("2% Interest Added to all Accounts: ");
                for(Account elem : accountList){
                  double interestAddition = elem.getBalance()*interest;
                  elem.depositToBalance(interestAddition);
                  System.out.println("Current balance for "+ elem.getFirstName()+" "+elem.getLastName()+" is: $"+ String.format("%.2f",elem.getBalance()));
                }
            }
            if(answer==5) {
                System.out.println("Would you like to:\n" + "1. Number of Savings Accounts:\n" + "2. Number of Checking Accounts:\n" + "3. Number of Student Accounts:\n" + "4. Number of Employee Accounts:");
                int option = scan.nextInt();
                if (option == 1) {
                    for (Account elem : accountList) {
                        if (elem.getAccountType() == 'S') {
                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
                        }
                    }
                }
                if (option == 2) {
                    for (Account elem : accountList) {
                        if (elem.getAccountType() == 'C') {
                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
                        }
                    }
                }
                if (option == 3) {
                    for (Account elem : accountList) {
                        if (elem.getPersonType() == 1) {
                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
                        }
                    }
                }
                if (option == 4) {
                    for (Account elem : accountList) {
                        if (elem.getPersonType() == 2 || elem.getPersonType() == 3) {
                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
                        }
                    }
                }
            }

            if(answer==6){
                quit=true;
            }
        }while(quit!=true);
        System.out.println("Done!");
        System.exit(0);

    }
}
