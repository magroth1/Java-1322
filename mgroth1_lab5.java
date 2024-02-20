import java.util.Objects;
import java.util.Scanner;

public class lab_5 {

    public static void main(String[] args) {
        Item[] items = new Item[5];
        Scanner s1 = new Scanner(System.in);
        String userChoice;


        String Title;
        String Author;
        int isbn;
        int issueNum;
        for(int i = 0;i < 5; i++){
            System.out.println("Please enter B for book or P for periodical");
            userChoice = s1.nextLine();

            if (Objects.equals(userChoice, "B") || Objects.equals(userChoice, "b")){
                System.out.println("Enter the name of the book");
                Title = s1.nextLine();
                System.out.println("who is the book's author?");
                Author = s1.nextLine();
                System.out.println("Enter the ISBN number of" + Title);
                isbn = s1.nextInt();
                book b1 = new book(Title, isbn, Author);
            }
            else {
                System.out.println("Enter the name of the periodical");
                Title = s1.nextLine();
                System.out.println("Enter the issue number of" + Title);
                issueNum = s1.nextInt();
                periodical p1 = new periodical(Title, issueNum);
                items[i] = p1;
            }
         }

        for(int i = 0; 0 < 5; i++){
            System.out.println("your books and periodicals \n" + items[i].getListing());
        }
    }

}

abstract class Item {
    private String title;

    public Item() {
        this.title = "";
    }
    public Item(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    abstract String getListing();

    @Override
    public String toString() {
        return title;
    }
}

class book extends Item{
    private int isbn_num;
    private String author;

    public int getIsbn_num() {
        return isbn_num;
    }
    public String getAuthor() {
        return author;
    }

    public void setIsbn_num(int isbn_num) {
        this.isbn_num = isbn_num;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public book(){
        super();
        this.isbn_num = 0;
        this.author = "";
    }
    public book(String title, int isbn_num, String author){
        super(title);
        this.isbn_num = isbn_num;
        this.author = author;
    }

    @Override
    public String getListing() {
        return ("Book title: " + this.getTitle() + "\nAuthor: " + this.getAuthor() + "\nISBN: #"+ this.getIsbn_num());
    }
}

class periodical extends Item{
    private int issueNum;

    public periodical(){
        this.issueNum = 0;
    }
    public periodical(String title, int issueNum){
        super(title);
        this.issueNum = issueNum;
    }

    public int getIssueNum() {
        return issueNum;
    }
    public void setIssueNum(int issueNum) {
        this.issueNum = issueNum;
    }
    @Override
    public String getListing(){
        return ("periodical title: " + this.getTitle() + "\nIssue Number: " + this.getIssueNum());
    }
}