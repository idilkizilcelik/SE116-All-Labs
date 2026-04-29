//Q1 Constructor is a method which is usen by to initialize the objects in the classes
//Q2 static means belongs to a class but non-static means belongs to the object
public class Bank{
    public static void main(String [] args){
        BankAccount account1 = new BankAccount("idil" , 11234512334L);
        BankAccount account2 = new BankAccount("kutay" ,11234512335L);
        account1.deposit(3545);
        account1.SendMoney(354, 11234512335L , account2);
        account2.displayAccountInfo();
        account1.displayAccountInfo();
    }
}
class BankAccount{
    private String OwnerName;
    private long Iban;
    private double Balance;
    public BankAccount(String OwnerName, long Iban){
        this.OwnerName=OwnerName;
        this.Iban=Iban;
        Balance=0;
    }
    public String getOwnerName(){
        return OwnerName;
    }
    public long getIban(){
        return Iban;
    }
    public double getBalance(){
        return Balance;
    }
    public void setOwnerName(String OwnerName){
    this.OwnerName=OwnerName;
    }
    public void setBalance(double Balance){
        this.Balance=Balance;
    }
    public void setIban(long Iban){
        this.Iban=Iban;
    }
    public void deposit(int amount){
        Balance=amount+Balance;
    }
    public boolean withdraw(int amount) {
        if (Balance < amount) {
            return false;
        } else {
            Balance = Balance - amount;
            return true;
        }
    }
    public void SendMoney(double amount , long Iban ,BankAccount account2){
        if (account2.getIban()== Iban && Balance>=amount){
            Balance-=amount;
            account2.setBalance(account2.getBalance() + amount);
        }else{
            System.out.println("Insufficient funds");
        }
    }
public void displayAccountInfo(){
        System.out.println(OwnerName + " " + Iban + " " + Balance);
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-");
}





}