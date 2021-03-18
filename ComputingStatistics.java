import java.util.ArrayList;

public class ComputingStatistics {
   /**
   * The ArrayList containing all of the loan data.
   */
   private ArrayList<Loan> data;
   
   /**
    * Creates a new ComputingStatistics object with an empty ArrayList 
    */
   public ComputingStatistics() {
      data = new ArrayList<Loan>();
   }
   
   /**
    * Creates a new ComputingStatistics object with the data passed in
    */
   public ComputingStatistics(ArrayList<Loan> d) {
      data = d;
   }
   
   /**
    * Calclates the total amount funded from all of the loans in the file.
    * @return the total loan amount.
    */
   public double totalAmount() {
      double amount = 0.0;
      for(int i = 0; i < data.size(); i++) {
         amount = amount + data.get(i).getLoanAmount();
      }
      return amount;
   }
   public double avgLoan(){
     double avg = this.totalAmount()/data.size();
     return avg;
   }
   public double largestLoan(){
     //Create double variable largest with the value of the first element of data
     double largest = data.get(0).getLoanAmount();
     //For each element of data in i:
     for(Loan i:data){
       //If the value of the loan amount of i is greater than the value of largest:
       if(i.getLoanAmount() > largest){
         //Set largest to the value of the loan amount of i
         largest = i.getLoanAmount();
       //End if
       }
     //End for
     }
     //Return largest
     return largest;
   }
   public double smallestLoan(){
     //Create double variable smallest with the value of the first element of data
     double smallest = data.get(0).getLoanAmount();
     //For each element of data in i:
     for(Loan i:data){
       //If the value of the loan amount of i is greater than the loan amount of largest:
       if(i.getLoanAmount() < smallest){
         //Set smallest to the value of the loan amount of i
         smallest = i.getLoanAmount();
       //End if
       }
     //End for
     }
     //Return smallest
     return smallest;
   }
   public String largestLoanCountry(){
     //Create Loan variable largest with the first element of data
     Loan largest = data.get(0);
     //For each element of data in i:
     for(Loan i:data){
       //If the value of the loan amount of i is greater than the loan amount of largest:
       if(i.getLoanAmount() > largest.getLoanAmount()){
         //Put largest into i
         largest = i;
       //End If
       }
     //End for
     }
     //Return the country of largest
     return largest.getCountry();
   }
   public String smallestLoanCountry(){
     Loan smallest = data.get(0);
     for(int i = 1; i < data.size(); i++){
       if(data.get(i).getLoanAmount() < smallest.getLoanAmount()){
         smallest = data.get(i);
       }
     }
     return smallest.getCountry();
   }
   public double avgDaysToFund(){
     int totalDays = 0;
     for(Loan i:data){
       totalDays += i.getDaysToFund();
     }
     return (double)totalDays/data.size();
   }
   public double largestLoanKenya(){
     double largest = (double)Integer.MIN_VALUE;
     for(Loan i:data){
       if(i.getCountry().equals("Kenya") && i.getLoanAmount() > largest){
         largest = i.getLoanAmount();
       }
     }
     return largest;
   }
   public double avgLoanPhilippines(){
     double totalAmount = 0;
     int numLoans = 0;
     for(Loan i:data){
       if(i.getCountry().equals("Philippines")){
         totalAmount += i.getLoanAmount();
         numLoans++;
       }
     }
     if(numLoans == 0){
       return 0;
     }
     return (double)totalAmount/numLoans;
   }
   public String longestToFundCountry(){
     int longest = Integer.MIN_VALUE;
     Loan longestLoan = data.get(0);
     for(Loan i:data){
       if(i.getDaysToFund() > longest){
         longest = i.getDaysToFund();
           longestLoan = i;
         }
       }
       return longestLoan.getCountry();
     }
   public String mostLoansFunded(){
     int countES = 0;
     int countK = 0;
     for(Loan i:data){
       if(i.getCountry().equals("El Salvador")){
         countES++;
       }
       if(i.getCountry().equals("Kenya")){
         countK++;
       }
     }
     if(countES > countK){
       return "El Salvador";
     }
     else{
       return "Kenya";
     }
   }
   public double variance(){
     double sumOfSquares = 0.0;
     for(Loan i:data){
       sumOfSquares += Math.pow(i.getLoanAmount() - this.avgLoan(), 2);
     }
     return (double)sumOfSquares/data.size(); 
   }
   public double standardDeviation(){
     return Math.sqrt(this.variance());
   }
   public boolean empiricalRule(){
     int count = 0;
     double max = this.avgLoan() + this.standardDeviation();
     double min = this.avgLoan() - this.standardDeviation();
     for(Loan i:data){
       if(i.getLoanAmount() <= max && i.getLoanAmount() >= min){
         count++;
       }
     }
     System.out.println(count);
     int percent = (int)((double)count/data.size()*100);
     System.out.println(percent);
     if(percent == 68){
       return true;
     }
     else{
       return false;
     }
   }
}