//Programmer: Joon Kyo Kim

import java.util.ArrayList;

public class Loan{
  //Instance variables
  private int ID;
  private double loanAmount;
  private String country;
  private int daysToFund;
  private int numLenders;
  //Constructor
  public Loan(int ident, double amount, String nation, int deadline, int lenders){
    ID = ident;
    loanAmount = amount;
    country = nation;
    daysToFund = deadline;
    numLenders = lenders;
  }
  //Accessor Methods
  public int getID(){
    return ID;
  }
  public double getLoanAmount(){
    return loanAmount;
  }
  public String getCountry(){
    return country;
  }
  public int getDaysToFund(){
    return daysToFund;
  }
  public int getNumLenders(){
    return numLenders;
  }
  //Modifier Methods
  public void setID(int newID){
    ID = newID;
  }
  public void setLoanAmount(double newAmount){
    loanAmount = newAmount;
  }
  public void setCountry(String newCountry){
    country = newCountry;
  }
  public void setDaysToFund(int days){
    daysToFund = days;
  }
  public void setNumLenders(int num){
    numLenders = num;
  }
  //toString
  public String toString(){
    return "Loan ID: " + ID + "\nLoan Amount: " + loanAmount + "\nCountry: " + country + "\nDays taken to Fund: " + daysToFund + "\nNumber of Lenders: " + numLenders;
  }
}