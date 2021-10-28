package SABank;

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
        int answer;
        int counter;
        int position;
        int option;
        int currentIndexCounter = 0;
        String firstName;
        String lastName;
        char gender;
        String birthday;
        char accountType;
        int personType;
        double deposit;
        double initialDeposit;

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

        accountList[0]= Amanda;
        currentIndexCounter++;
        accountList[1]= Timmy;
        currentIndexCounter++;
        accountList[2]= Ellie;
        currentIndexCounter++;
        accountList[3]= Hannah;
        currentIndexCounter++;
        accountList[4]= Kurt;
        currentIndexCounter++;

        if (currentIndexCounter == accountList.length){
            Account[] tempAccountList = new Account[accountList.length * 2];
            for (int i = 0; i<accountList.length; i++){
                tempAccountList[i] = accountList[i];
            }
            accountList = tempAccountList;

            accountList[5]= Mark;
            currentIndexCounter++;
            accountList[6]= Bill;
            currentIndexCounter++;
            accountList[7]= Carol;
            currentIndexCounter++;
            accountList[8]= Liam;
            currentIndexCounter++;
            accountList[9]= Ashley;
            currentIndexCounter++;
        }

        if (currentIndexCounter == accountList.length){
            Account[] tempAccountList = new Account[accountList.length * 2];
            for (int i = 0; i<accountList.length; i++){
                tempAccountList[i] = accountList[i];
            }
            accountList = tempAccountList;
            accountList[10]= Barry;
            accountList[11]= Fred;
            accountList[12]= Jim;
            accountList[13]= Gary;
            accountList[14]= Linda;
        }

        System.out.println("Welcome to the Saint Anselm Bank!");
        do {
            System.out.println("\nPlease select one of the options below:");
            System.out.println("1. Display All Accounts\n" + "2. Total Number of Accounts\n" + "3. Open a New Account with Initial Deposit\n" + "4. Open a New Account with no Deposit\n" + "5. Add Interest to All Accounts\n" + "6. Display Student Accounts with Balance less than $100\n" + "7. Display all Employee Accounts with a Balance over $5000\n" + "8. Linear Search for Account Holder\n" + "9. Display Savings Accounts based on a Bubble Sort by First Name\n" + "10. Exit\n");
            answer = scan.nextInt();
            if (answer == 1) {
                //System.out.println("First Name," + " " + "Last Name," + " " + "Gender" + " " + "Birthday" + " " + "Social Security Number" + " " + "Account Number" + " " + "Account Type"+ " " + "Person Type" + " " + "Balance");
                for (Account elem : accountList) {
                    if(elem != null)
                        System.out.println(elem.displayAllAccountInfo());
                }
            }

            if (answer == 2) {
                counter = 0;
                System.out.println("Would you like to see:\n" + "1. Number of Savings Accounts:\n" + "2. Number of Checking Accounts:\n" + "3. Back to Main Menu:\n");
                option = scan.nextInt();
                if (option == 1) {
                    for (Account elem : accountList) {
                        if (elem != null && elem.getAccountType() == 'S') {
                            counter++;
                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
                        }
                    }
                    System.out.println("Number of Savings Accounts: " + counter);
                }
                if (option == 2) {
                    for (Account elem : accountList) {
                        if (elem != null && elem.getAccountType() == 'C') {
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
                firstName = scan.nextLine();
                System.out.print("Last Name: ");
                lastName = scan.nextLine();
                System.out.print("Gender (M/F): ");
                gender = scan.next().charAt(0);
                System.out.print("Birthday (In the form MM/DD/YY): ");
                scan.nextLine();
                birthday = scan.nextLine();
                System.out.print("Checking ('C') or Savings?('S'): ");
                accountType = scan.next().charAt(0);
                System.out.print("Occupation (Student='1', Staff='2', Faculty='3'): ");
                personType = scan.nextInt();
                System.out.print("Deposit: ");
                initialDeposit = scan.nextDouble();
                Account newAccount = new Account (firstName, lastName, gender, birthday, accountType, personType, initialDeposit);

                currentIndexCounter = 0;
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
                    tempArray[currentIndexCounter] = newAccount;
                    accountList=tempArray;
                }
                else { //If it is big enough, a new array does not need to be created (for size reasons), and the "newAccount" will be added to "accountList" as usual
                    accountList[currentIndexCounter] = newAccount;
                }

                System.out.println("Your account has been successfully created " + firstName + ".\nThank you for banking with Saint Anselm Bank!");
            }

            if (answer == 4) {
                System.out.println("Thank you for deciding to open a new account here at Saint Anselm Bank!\nWe are going to need some information from you to get started:");
                System.out.print("First Name: ");
                scan.nextLine();
                firstName = scan.nextLine();
                System.out.print("Last Name: ");
                lastName = scan.nextLine();
                System.out.print("Gender (M/F): ");
                gender = scan.next().charAt(0);
                System.out.print("Birthday (In the form MM/DD/YY): ");
                scan.nextLine();
                birthday = scan.nextLine();
                System.out.print("Checking ('C') or Savings?('S'): ");
                accountType = scan.next().charAt(0);
                System.out.print("Occupation (Student='1', Staff='2', Faculty='3'): ");
                personType = scan.nextInt();
                Account newAccount = new Account(firstName, lastName, gender, birthday, accountType, personType);

                currentIndexCounter = 0;
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
                    tempArray[currentIndexCounter] = newAccount;
                    accountList=tempArray;
                }
                else { //If it is big enough, a new array does not need to be created (for size reasons), and the "newAccount" will be added to "accountList" as usual
                    accountList[currentIndexCounter] = newAccount;
                }

                System.out.println("Your account has been successfully created " + firstName + ".\nThank you for banking with Saint Anselm Bank!");
            }

            if (answer == 5) {
                System.out.println("2% Interest Added to all Accounts: ");
                for (Account elem : accountList) {
                    if(elem != null) {
                        double interestAddition = elem.getBalance() * interest;
                        elem.depositToBalance(interestAddition);
                        System.out.println("Current balance for " + elem.getFirstName() + " " + elem.getLastName() + " is: $" + String.format("%.2f", elem.getBalance()));
                    }
                }
            }

            if (answer == 6) {
                System.out.println("The following students have a balance below 100 dollars\nand will receive a letter from the bank about their low balance:");
                for (Account elem : accountList) {
                    if (elem != null && elem.getPersonType() == 1) {
                        if (elem.getBalance() < 100) {
                            System.out.println(elem.getFirstName() + " " + elem.getLastName());
                        }
                    }
                }
            }

            if (answer == 7) {
                System.out.println("The following employee accounts are eligible for a promotional credit card offer:");
                for (Account elem : accountList) {
                    if (elem != null && (elem.getPersonType() == 2 || elem.getPersonType() == 3)) {
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
                    if (elem != null && elem.getLastName().equalsIgnoreCase(lastNameResponse)) {
                        System.out.println("Please enter first name of account as well in order to ensure the right account is accessed: ");
                        String firstNameResponse = scan.nextLine();
                        if (elem.getFirstName().equalsIgnoreCase(firstNameResponse)) {
                            System.out.print("Would you like to:\n 1. Check Balance\n 2. Withdraw Money\n 3. Deposit Money\n 4. Add Interest\n 5. Delete Account\n 6. Back to Main Menu\n");
                            int selection = scan.nextInt();
                            if (selection == 1) {
                                System.out.println("The account's balance is: $" + String.format("%.2f", elem.getBalance()));
                            }
                            if (selection == 2) {
                                while (!done) {
                                    System.out.print("Current balance of this account: $"+String.format("%.2f", elem.getBalance())+".\nHow much would you like to withdraw from that account?\n$");
                                    withdrawal = scan.nextDouble();

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
                                System.out.print("How much would you like to deposit?\n$");
                                deposit = scan.nextDouble();
                                elem.depositToBalance(deposit);
                                System.out.println("The amount $" + String.format("%.2f", deposit) + " has been added to the account\n Current Balance: $" + String.format("%.2f", elem.getBalance()));
                            }
                            if (selection == 4) {
                                double interestAddition = elem.getBalance() * interest;
                                elem.depositToBalance(interestAddition);
                                System.out.println("Current balance for " + elem.getFirstName() + " " + elem.getLastName() + " with interest is: " + String.format("%.2f", elem.getBalance()));
                            }
                            if (selection == 5) {
                                Account[] tempArray = new Account[accountList.length - 1];
                                for (int i = 0, j = 0; i < accountList.length; i++) {
                                    if (accountList[i] != null && accountList[i].getLastName() != elem.getLastName() && accountList[i].getFirstName() != elem.getFirstName()) {
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
                    }
                    else {
                        count += 1;
                        if (count == accountList.length) {
                            System.out.println("An account under that last name doesn't exist.");
                        }
                    }
                }
                count = 0;
            }

            if (answer == 9){
                counter = 0;
                position = 0;

                for (Account elem : accountList) {
                    if (elem != null && elem.getAccountType() == 'S') {
                        counter++;
                    }
                }

                Account[] savingAccountsArray= new Account[counter];

                for (Account elem : accountList) {
                    if( elem != null && elem.getAccountType() == 'S') {
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