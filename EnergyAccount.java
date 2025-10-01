//Programmed by: 
//Assignment: Project One: Energy Account
//Purpose (of this file): Declare and create the class used in driver.java

public class EnergyAccount {
    
    //private member constants
    private double balance;
    private double renewableRate;
    private double lastCredit;
    //getters
    public double getBalance() {
        return balance;
    }
    public double getLastCredit(){
        return lastCredit;
    }
    public double getRenewableRate(){
        return renewableRate;
    }
    //Constructor
    EnergyAccount(double bal, double rate){
        //Construstor should accept starting balance and the renewable rate (this as a decimal, where .10 = 10%)
    }

    void consume(double amount){
        //Subtracts consumed energy
        balance -= amount;
    }

    void generate(double amount){
        //Crediting renewable energy production (usint renewable rate)
        double generated;
        generated = amount * renewableRate;
        balance += generated;
    }

    void addRenewableCredit(){
        double credited;
        credited = balance * renewableRate;
        balance += credited;
    }
}
//Class stores monthly energy balance (kWh (kilowatt-hours)) and a renewable energy rate (percent of energy genned by solar/wind/water/etc) and the last credited renewable energy amount