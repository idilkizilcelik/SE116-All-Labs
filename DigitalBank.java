public class DigitalBank{
class BankAccount{
    private String ownerName;
    private long iban;
    private int balance;
    private String[] transactionHistory;
    public BankAccount(String ownerName, long iban, String[] transactionHistory){
        this.ownerName=ownerName;
        this.iban=iban;
        this.transactionHistory= new String[10];
        balance=0;
    }
    public String getownerName(){return ownerName;}
    public long getiban(){return iban;}
    public int getbalance(){return balance;}
    public String[] gettransactionHistory(){return transactionHistory;}
    public void setownerName(String ownerName){this.ownerName=ownerName;}
    public void setiban(long iban){this.iban=iban;}
    public void setbalance(int balance){this.balance=balance;}
    public void settransactionHistory(String[]transactionHistory){
        this.transactionHistory=transactionHistory;
    }
    public void addTransaction(String record){

        if(transactionHistory.equals(null){
            transactionHistory+=record;
        }


    }


}
}