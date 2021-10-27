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
        //int newUserAccountCounter = 0; //Used as a new user input naming convention
        //Student Accounts (3 Checking, 2 Savings)
        Account Amanda = new Account("Amanda","Turner",'F',"02/22/02",'C',1,1200);
        Account Timmy = new Account("Timmy","Brown",'M',"07/04/01",'C',1);
        Account Ellie = new Account("Ellie","Smith",'F',"05/09/00",'C',1,5000);
        Account Hannah = new Account("Hannah","Sock",'F',"10/13/01",'S',1);
        Account Kurt = new Account("Kurt","Williams",'M',"02/20/99",'S',1,6200);
        //Faculty Accounts (3 Checking, 2 Savings)
        Account Mark = new Account("Mark","Thompson",'M',"11/24/78",'C',2);
        Account Bill = new Account("Bill","Harry",'M',"12/19/75",'C',2);
        Account Carol = new Account("Carol","White",'F',"04/23/74",'C',2, 7200);
        Account Liam = new Account("Liam","Brady",'M',"01/07/69",'S',2);
        Account Ashley = new Account("Ashley","Jones",'F',"03/24/66",'S',2, 10000);
        //Staff Accounts (3 Checking, 2 Savings)
        Account Barry = new Account("Barry","Allen",'M',"03/14/68",'C',3);
        Account Fred = new Account("Fred", "Adrian", 'M', "08/30/63", 'C', 3, 9000);
        Account Jim = new Account("Jim", "Carrey", 'M', "09/26/67", 'C', 3);
        Account Gary = new Account("Gary", "Bolden", 'M', "07/29/65", 'S', 3, 4700);
        Account Linda = new Account("Linda", "Andrews", 'F', "03/15/71", 'S', 3, 11000);

        int MAX = 5; //Variable used to dynamically change the size of the accountList Array
        Account[] accountList = new Account[MAX];
        accountList[0]= Timmy;
        accountList[1]= Mark;
        accountList[2]= Ellie;
        accountList[3]= Barry;
        accountList[4]= Amanda;
        System.out.println("Welcome to the Saint Anselm Bank!");
        do {
            System.out.println("Please select one of the options below:");
            System.out.println("1. Display All Accounts\n" + "2. Total Number of Accounts\n" + "3. Open a New Account with Initial Deposit\n" + "4. Open a New Account with no Deposit\n" + "5. Add Interest to All Accounts\n" + "6. Display Student Accounts with Balance less than $100\n" + "7. Display all Employee Accounts with a Balance over $5000\n" + "8. Linear Search for Account Holder\n" + "9. Display Savings Accounts based on a Bubble Sort by First Name\n" + "10. Exit\n");
            int answer = scan.nextInt();
            if (answer == 1) {
                //System.out.println("First Name," + " " + "Last Name," + " " + "Gender" + " " + "Birthday" + " " + "Social Security Number" + " " + "Account Number" + " " + "Account Type"+ " " + "Person Type" + " " + "Balance");
                for (Account elem : accountList) {
                    System.out.println(elem.displayAllAccountInfo());
                }
            }

            if (answer == 2) {
                int counter = 0;
                System.out.println("Would you like to see:\n" + "1. Number of Savings Accounts:\n" + "2. Number of Checking Accounts:\n" + "3. Back to Main Menu:\n");
                int option = scan.nextInt();
                if (option == 1) {
                    for (Account elem : accountList) {
                        if (elem.getAccountType() == 'S') {
                            counter++;
                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
                        }
                    }
                    System.out.println("Number of Savings Accounts: " + counter);
                }
                if (option == 2) {
                    for (Account elem : accountList) {
                        if (elem.getAccountType() == 'C') {
                            counter++;
                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
                        }
                    }
                    System.out.println("Number of Checking Accounts: " + counter);
                }
                if (option == 3) {
                    continue;
                }
            }

            if (answer == 3) {
                System.out.println("Thank you for deciding to open a new account here at Saint Anselm Bank!\nWe are going to need some information from you to get started:");
                System.out.print("First Name: ");
                scan.nextLine();
                String firstName = scan.nextLine();
                System.out.print("Last Name: ");
                scan.nextLine();
                String lastName = scan.nextLine();
                System.out.print("Gender (M/F): ");
                char gender = scan.next().charAt(0);
                System.out.print("Birthday (In the form MM/DD/YY): ");
                scan.nextLine();
                String birthday = scan.nextLine();
                System.out.print("Checking ('C') or Savings?('S'): ");
                char accountType = scan.next().charAt(0);
                System.out.print("Occupation (Student='1', Staff='2', Faculty='3'): ");
                int personType = scan.nextInt();
                System.out.print("Deposit: ");
                double initialDeposit = scan.nextDouble();
                //String newAccount = "test"+newUserAccountCounter;
                Account newAccount = new Account(firstName, lastName, gender, birthday, accountType, personType, initialDeposit);
                int currentIndexCounter = 0;
                for (int i = 0; i < accountList.length; i++) { //Checks to see if "accountList" is big enough to take more input
                    if (accountList[i] != null) {
                        currentIndexCounter++;
                    }
                }
                if (currentIndexCounter == accountList.length) { //If not, a new temporary array must be created
                    Account[] tempArray = new Account[accountList.length * 2];
                    for (int i = 0; i < accountList.length; i++) { //Takes all old values from "accountList" array and adds them to the new "tempArray"
                        tempArray[i] = accountList[i];
                    }
                    tempArray[currentIndexCounter + 1] = newAccount;
                    //accountList = null;
                    accountList=tempArray; //Issue here and need to implement in choice 4 and top of file with default accounts
                }
                else { //If it is big enough, a new array does not need to be created (for size reasons), and the "newAccount" will be added to "accountList" as usual
                    accountList[currentIndexCounter] = newAccount;
                }

                //MAX = accountList.length*2
                //Account accountList = new Account[MAX]
                //accountList[0]=newAccount;
                System.out.println("Your account has been successfully created " + firstName + ".\nThank you for banking with Saint Anselm Bank!");
                //Not Permanent
                System.out.println("***The following should not be in the final version of the code***");
                for (int i = 0; i < accountList.length; i++){
                    System.out.println(accountList[i].getFirstName());
                }
            }

            if (answer == 4) {
                System.out.println("Thank you for deciding to open a new account here at Saint Anselm Bank!\nWe are going to need some information from you to get started:");
                System.out.print("First Name: ");
                String firstName = scan.nextLine();
                System.out.print("Last Name: ");
                String lastName = scan.nextLine();
                System.out.print("Gender (M/F): ");
                char gender = scan.next().charAt(0);
                System.out.print("Birthday (In the form MM/DD/YY): ");
                String birthday = scan.nextLine();
                System.out.print("Checking ('C') or Savings?('S'): ");
                char accountType = scan.next().charAt(0);
                System.out.print("Occupation (Student='1', Staff='2', Faculty='3'): ");
                int personType = scan.nextInt();
                Account newAccount = new Account(firstName, lastName, gender, birthday, accountType, personType);
                System.out.println("Your account has been successfully created " + firstName + ".\nThank you for banking with Saint Anselm Bank!");
            }

            if (answer == 5) {
                System.out.println("2% Interest Added to all Accounts: ");
                for (Account elem : accountList) {
                    double interestAddition = elem.getBalance() * interest;
                    elem.depositToBalance(interestAddition);
                    System.out.println("Current balance for " + elem.getFirstName() + " " + elem.getLastName() + " is: $" + String.format("%.2f", elem.getBalance()));
                }
            }

            if (answer == 6) {
                for (Account elem : accountList) {
                    if (elem.getPersonType() == 1) {
                        if (elem.getBalance() < 100) {
                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
                        }
                    }
                }
            }

            if (answer == 7) {
                for (Account elem : accountList) {
                    if (elem.getPersonType() == 2 || elem.getPersonType() == 3) {
                        if (elem.getBalance() > 5000) {
                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
                        }
                    }
                }
            }

            if (answer == 8) {
                System.out.println("Which account would you like to access (Please enter last name of account)");
                scan.nextLine();
                String lastNameResponse = scan.nextLine();
                for (Account elem : accountList) {
                    if (elem.getLastName().equalsIgnoreCase(lastNameResponse)) {
                        System.out.println("Please enter first name of account as well in order to ensure the right account is accessed: ");
                        String firstNameResponse = scan.nextLine();
                        if (elem.getFirstName().equalsIgnoreCase(firstNameResponse)) {
                            System.out.print("Would you like to:\n 1. Check Balance\n 2. Withdraw Money\n 3. Deposit Money\n 4. Add Interest\n 5. Delete Account\n 6. Back to Main Menu");
                            int selection = scan.nextInt();
                            if (selection == 1) {
                                System.out.println("The account's balance is: " + elem.getBalance());
                            }
                            if (selection == 2) {
                                System.out.print("How much would you like to withdraw from that account?\n$");
                                withdrawal = scan.nextDouble();
                                while (!done) {

                                    if (withdrawal > elem.getBalance()) {
                                        System.out.println("The account does not have enough money to make a withdrawal of that size.");
                                        done = false;
                                    } else {
                                        elem.withdrawFromBalance(withdrawal);
                                        System.out.println("The amount $" + String.format("%.2f", withdrawal) + " has been removed to the account\n Current Balance: $" + String.format("%.2f", elem.getBalance()));
                                        break;
                                    }
                                }
                            }
                            if (selection == 3) {
                                double deposit = scan.nextDouble();
                                elem.depositToBalance(deposit);
                                System.out.println("The amount $" + String.format("%.2f", deposit) + " has been added to the account\n Current Balance: $" + String.format("%.2f", elem.getBalance()));
                            }
                            if (selection == 4) {
                                double interestAddition = elem.getBalance() * interest;
                                elem.depositToBalance(interestAddition);
                                System.out.println("Current balance for " + elem.getFirstName() + " " + elem.getLastName() + "is: " + elem.getBalance());
                            }
                            if (selection == 5) {
                                Account[] tempArray = new Account[accountList.length - 1];
                                for (int i = 0, j = 0; i < accountList.length; i++) {
                                    if (accountList[i].getLastName() != elem.getLastName() && accountList[i].getFirstName() != elem.getFirstName()) {
                                        tempArray[j++] = accountList[i];
                                    }
                                }
                                int i = 0;
                                for (Account part : tempArray) {
                                    accountList[i] = part;
                                    i += 1;
                                }

                            }
                            if (selection == 6) {
                                continue;
                            }


                        } else {
                            count += 1;
                            if (count == accountList.length) {
                                System.out.println("An account under that first name doesn't exist.");
                            }
                        }
                    } else {
                        count += 1;
                        if (count == accountList.length) {
                            System.out.println("An account under that last name doesn't exist.");
                        }
                    }
                }
                count = 0;
            }

            if (answer == 3) {
                System.out.println("Which account would you like to withdraw from? (Please enter last name of account)");
                scan.nextLine();
                String lastNameResponse = scan.nextLine();
                for (Account elem : accountList) {
                    if (elem.getLastName().equalsIgnoreCase(lastNameResponse)) {
                        System.out.println("Which account would you like to withdraw from? (Please enter first name of account)");
                        String firstNameResponse = scan.nextLine();
                        if (elem.getFirstName().equalsIgnoreCase(firstNameResponse)) {
                            System.out.print("How much would you like to withdraw from that account?\n$");
                            withdrawal = scan.nextDouble();
                            while (done == false) {

                                if (withdrawal > elem.getBalance()) {
                                    System.out.println("You do not have enough money make a withdrawal of that size.");
                                    done = false;
                                } else {
                                    elem.withdrawFromBalance(withdrawal);
                                    System.out.println("The amount $" + String.format("%.2f", withdrawal) + " has been removed to the account\n Current Balance: $" + String.format("%.2f", elem.getBalance()));
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
                        } else {
                            count += 1;
                            if (count == accountList.length) {
                                System.out.println("An account under that first name doesn't exist.");
                            }
                        }
                    } else {
                        count += 1;
                        if (count == accountList.length) {
                            System.out.println("An account under that last name doesn't exist.");
                        }
                    }
                }
                count = 0;
            }

            if (answer == 9){
                int counter = 0;
                int position = 0;

                for (Account elem : accountList) {
                    if (elem.getAccountType() == 'S') {
                        counter++;
                    }
                }

                Account[] savingAccountsArray= new Account[counter];

                for (Account elem : accountList) {
                    if(elem.getAccountType() == 'S') {
                        savingAccountsArray[position] = elem;
                        position++;
                    }
                }

                for(int iteration = savingAccountsArray.length - 1; iteration >= 0; iteration--){
                    for (int i = 0; i < savingAccountsArray.length - 1; i++) {
                        if (savingAccountsArray[i].getFirstName().compareTo(savingAccountsArray[i + 1].getFirstName()) > 0) {
                            Account tempAccount = savingAccountsArray[i + 1];
                            savingAccountsArray[i + 1] = savingAccountsArray[i];
                            savingAccountsArray[i] = tempAccount;
                        }
                    }
                }

                System.out.println("Savings Accounts:");

                for (Account elem : savingAccountsArray){
                    System.out.println(elem.displayAllAccountInfo());
                }

                System.out.println();

            }

            if(answer==10){
                quit=true;
            }

        }while(!quit);
        System.out.println("Done!");
        System.exit(0);
    }
}

//                if (option == 3) {
//                    for (Account elem : accountList){
//                        if (elem.getPersonType() == 1) {
//                            counter++;
//                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
//                        }
//                    }
//                    System.out.println("Number of Student Accounts: "+counter);
//                }
//                if (option == 4) {
//                    for (Account elem : accountList) {
//                        if (elem.getPersonType() == 2 || elem.getPersonType() == 3) {
//                            counter++;
//                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
//                        }
//                    }
//                    System.out.println("Number of Faculty Accounts: "+counter);
//}
