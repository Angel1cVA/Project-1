//Programmed by:
//Assignment: Project One: Energy Account
//Purpose (of this file): Driver file for class, actually goes in and completes the assigned outputs and calculations
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) {
        //create a scanner to take inputs
        Scanner scanner = new Scanner(System.in);
        
        //get the starting balance for our constructor
        System.out.print("Enter a starting energy balance(kWh): ");
        double startingBalance = scanner.nextDouble();
        //if balance is negative, get new input
        if (startingBalance < 0){
            System.out.println("You must enter a starting energy balance greater than or equal to zero");
            System.out.print("Enter a starting energy balance(kWh): ");
            startingBalance = scanner.nextDouble();
        }
        //get renewable rate for constructor
        System.out.print("Enter your renewable rate (as a decimal, eg: .10 = 10%): ");
        double renewRate = scanner.nextDouble();
        //if renewable rate is < 0 or > 1, get new input
        if (renewRate <= 0 || renewRate >= 1){
            System.out.println("You must enter a valid number. Please enter a decimal, between 0 and 1");
            System.out.print("Enter your renewable rate (as a decimal, eg: .10 = 10%): ");
            renewRate = scanner.nextDouble();
        }
        EnergyAccount account = new EnergyAccount(startingBalance, renewRate);
        //find the amount of months to print this for
        System.out.print("Enter a number of months to smulate: ");
        int months = scanner.nextInt();
        if (months <= 0){
            System.out.println("Please enter a number of months greater than zero");
            System.out.print("Enter a number of months to smulate: ");
            months = scanner.nextInt();
        }

        //loop through an amount of times equal to the amount of months
        System.out.println("== Simulation Begin ==");
        for (int count = 0; count < months; count++){
            System.out.println("-- Month " + (count + 1) + " --");
            System.out.print("Energy consumed this month (kWh): ");
            //Must be a double, since account.consumed takes a double
            double consumed = scanner.nextDouble();
            if (consumed < 0){
                System.out.println("Please input a number greater than zero");
                System.out.print("Energy consumed this month (kWh): ");
                consumed = scanner.nextDouble();
            }
            //consume after recieving valid input
            account.consume(consumed);
            System.out.print("Energy generated this month (kWh): ");
            //Must be a double
            double generated = scanner.nextDouble();
            if (generated < 0){
                System.out.println("Please input a number greater than zero");
                System.out.print("Energy generated this month (kWh): ");
                generated = scanner.nextDouble();
            }
            //generate after recieving valid input
            account.generate(generated);
            account.addRenewableCredit();
            double credited = account.getLastCredit();
            double balance = account.getBalance();
            System.out.println("Renewable credit applied: " + credited + "kWh");
            System.out.println("Balance after month " + (count + 1) + ": " + balance + "kWh");
        }
        System.out.println("== Simulation Complete ==");
        double balance = account.getBalance();
        System.out.print("Final balance: " + balance + "kWh");

        scanner.close();
    }
}
