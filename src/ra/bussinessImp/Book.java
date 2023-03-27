package ra.bussinessImp;

import ra.bussiness.IBook;
import static ra.run.BookManagement.*;

public class Book implements IBook, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = exportPrice - importPrice;
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        // Input book ID:
        this.bookId = (books.isEmpty()) ? 0 : books.size();

        // Input book name:
        System.out.print("Input book name: ");
        this.bookName = sc.nextLine();

        // Input book title:
        System.out.print("Input book title: ");
        this.title = sc.nextLine();


        // Input book numberOfPages:
        while (true){
            System.out.print("Input book number of page: ");
            int numberOfPages = Integer.parseInt(sc.nextLine());
            if (numberOfPages < 10){
                System.out.println("Sorry your number of page at least 10!");
                System.out.println("Please try again!\n");
            } else {
                this.numberOfPages = numberOfPages;
                break;
            }
        }


        // Input book importPrice:
        while (true){
            System.out.print("Input book importPrice: ");
            float importPrice = Float.parseFloat(sc.nextLine());
            if (importPrice <= 0){
                System.out.println("Sorry your importPrice higher than 0!");
                System.out.println("Please try again!\n");
            } else {
                this.importPrice = importPrice;
                break;
            }
        }




        // Input book exportPrice:
        while (true){
            System.out.print("Input book exportPrice: ");
            float exportPrice = Float.parseFloat(sc.nextLine());
            if (exportPrice <= 0){
                System.out.println("Sorry your importPrice higher than 0!");
                System.out.println("Please try again!\n");
            } else {
                this.exportPrice = exportPrice;
                break;
            }
        }

        //Input book interest:
        System.out.print("Input book interest: ");
        this.interest = this.exportPrice - this.importPrice;


        // Input book status:
        while (true) {
            System.out.println("Select book status: \n" + "1. Sale\n" + "2. Sold out\n");
            System.out.print("Please select option: ");
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                this.bookStatus = true;
                break;
            }else if (option == 2) {
                this.bookStatus = false;
                break;
            }else{
                System.out.println("Not match any option!");
                System.out.println("Please try again!\n");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("bookId: " + bookId + " | " +
                "bookName: " + bookName + " | " +
                "title: " + title + " | " +
                "bookStatus: " + ((bookStatus) ? "Sale" : "Sold out"));
        System.out.println("importPrice: " + importPrice + " | " +
                "exportPrice: " + exportPrice + " | " +
                "interest: " + interest);
    }

    @Override
    public int compareTo(Book o) {
        return Float.compare(this.interest, o.getInterest());
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }



}
