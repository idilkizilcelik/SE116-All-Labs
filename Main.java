import java.util.Scanner;
 class Book{
    private String  isbn;
    private int PageCount;
    private String title;
    private int price;
    public Book (String  isbn, int PageCount, String title , int price){
        this.isbn= isbn;
        this.PageCount= PageCount;
        this.title= title;
        this.price= price;
    }
    public String getisbn(){
        return this.isbn;
    }
    public int getPageCount(){
        return this.PageCount;
    }
    public String gettitle(){
     return this.title;}
     public int getprice(){
        return this.price;
     }
     public void setisbn(String  isbn){
        this.isbn= isbn;
     }
     public void setPageCount(int PageCount){
        this.PageCount=PageCount;
     }
     public void settitle(String title){
        this.title=title;
     }
     public void setprice(int price){
        this.price=price;
     }
}
class Librarians {
    private int employeeID;
    private String name;
    private int age;
    private Book[] respbooks;

    public Librarians(int employeeID, String name, int age) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.respbooks = new Book[5];
    }

    public int getemployeeID() {
        return employeeID;
    }

    public String getname() {
        return name;
    }

    public int getage() {
        return age;
    }

    public Book[] getrespbooks() {
        return respbooks;
    }

    public void setemployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setage(int age) {
        this.age = age;
    }

    public void setrespbooks(Book[] respbooks) {
        this.respbooks = respbooks;
    }

    Scanner sc = new Scanner(System.in);

    public Librarians adbook(Book book) {
        for (int i = 0; i < 5; i++) {
            if (respbooks[i] == null) {
                respbooks[i] = book;
            }
        }
        return null;
    }

    public Book removeBook(String isbn) {
        for (int i = 0; i < 5; i++) {
            if (respbooks[i].getisbn().equals(isbn)) {
                respbooks[i] = null;
                return respbooks[i];
            }
        }
        return null;
    }

    public Book findbook(String isbn) {
        for (int i = 0; i < 5; i++) {
            if (respbooks[i].getisbn().equals(isbn))
                return respbooks[i];
        }
        return null;
    }

    public Book updateprice(Book book, double newPrice) {
        if (book != null) {
            book.setprice((int) newPrice);
        }
        return null;
    }
    public Book findBookAndApplyDiscount(String isbn, double discountPercentage){
        Book book= findbook(isbn);
        if (book !=null){
            double newPrice = book.getprice() * (1 - discountPercentage / 100);
            updateprice(book, newPrice);
        }
        return null;
}
    public Librarians displayallbooks(int enteremployeeID){
        if(employeeID== enteremployeeID){
            System.out.println(respbooks);
        }
        return null;

    }

}
public class Main{
     public static void main(String [] args){
         Scanner sc = new Scanner(System.in);
         Book a = new Book;
         Librarians b = new Librarians (2229 ,"John", 23);
         b.adbook("Little Prince");
         b.displayallbooks(2229);

     }
}
  