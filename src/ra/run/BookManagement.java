package ra.run;

import ra.bussinessImp.Book;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class BookManagement {
    public static Scanner sc = new Scanner(System.in);
    public static LinkedList<Book> books = new LinkedList<>();

    public static void main(String[] args) {

        while (true) {
            showMenu();
            System.out.print("Please select your option: ");
            int selectedOption = Integer.parseInt(sc.nextLine());
            switch (selectedOption) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayList();
                    break;
                case 3:
                    sortByInterestDES();
                    break;
                case 4:
                    deleteByID();
                    break;
                case 5:
                    findByName();
                    break;
                case 6:
                    changeBookStatusByID();
                    break;
                case 7:
                    System.out.println("See you again!");
                    return;
                default:
                    System.out.println("Not match any option!");
                    System.out.println("Please select again!\n");
                    break;
            }
        }

    }

    private static void showMenu() {
        System.out.println(
                "-----------------------| MENU |-----------------------\n" +
                        "1. Nhập số sách và nhập thông tin sách\n" +
                        "2. Hiển thị thông tin các sách\n" +
                        "3. Sắp xếp sách theo lợi nhuận giảm dần\n" +
                        "4. Xóa sách theo mã sách\n" +
                        "5. Tìm kiếm sách theo tên sách\n" +
                        "6. Thay đổi trạng thái của sách theo mã sách\n" +
                        "7. Thoát\n" +
                        "---------------------------------------------------\n");

    }

    private static void addBook() {
        System.out.print("Please input number of book: ");
        int numberOfBook = Integer.parseInt(sc.nextLine());
        System.out.println();
        if (numberOfBook <= 0) {
            System.out.println("Sorry, your number of book at least 1!");
            System.out.println("Please try again!\n");
        } else {
            for (int i = 1; i <= numberOfBook; i++) {
                System.out.println("Please input book " + i + " data:");
                Book newBook = new Book();
                newBook.inputData();
                books.add(newBook);
                System.out.println("Add new book successfully!\n");
            }
        }
    }

    private static void displayList() {
        if (books.isEmpty()) {
            System.out.println("Not have any book in list!");
            System.out.println("Please add some book to list then try again!");
        } else {
            for (Book book : books) {
                System.out.println("-------------------------------------");
                book.displayData();
                System.out.println("-------------------------------------\n");
            }
        }
    }

    private static void sortByInterestDES() {
        if (books.isEmpty()) {
            System.out.println("Not have any book in list!");
            System.out.println("Please add some book to list then try again!");
        } else {
            books.sort(Collections.reverseOrder());
            System.out.println("Sort list successfully!");
        }
    }

    private static void deleteByID() {
        if (books.isEmpty()) {
            System.out.println("Not have any book in list!");
            System.out.println("Please add some book to list then try again!");
        } else {
            displayList();
            System.out.print("Please input Id to delete: ");
            int selectedBookID = Integer.parseInt(sc.nextLine());
            for (Book book : books){
                if (book.getBookId() == selectedBookID){
                    books.remove(book);
                    System.out.println("Delete successfully!");
                    return;
                }
            }
            System.out.println("Not found any Id match your input Id!");
            System.out.println("Please try again!\n");
        }
    }

    private static void findByName() {
        if (books.isEmpty()) {
            System.out.println("Not have any book in list!");
            System.out.println("Please add some book to list then try again!");
        } else {
            System.out.print("Please input the name of book you want to search: ");
            String bookName = sc.nextLine();
            boolean isContain = false;
            for (Book book : books) {
                if (book.getBookName().contains(bookName)) {
                    System.out.println("-------------------------------------");
                    book.displayData();
                    System.out.println("-------------------------------------\n");
                    isContain = true;
                }
            }
            if (!isContain){
                System.out.println("Not found any name match with your input!");
                System.out.println("Please try again!\n");
            }
        }
    }

    private static void changeBookStatusByID() {
        if (books.isEmpty()) {
            System.out.println("Not have any book in list!");
            System.out.println("Please add some book to list then try again!");
        } else {
            displayList();
            System.out.print("Please input book ID to change status: ");
            int bookID = Integer.parseInt(sc.nextLine());
            for (Book book : books) {
                if (book.getBookId() == bookID) {
                    book.setBookStatus(!book.isBookStatus());
                    System.out.println("Change status successfully!");
                    return;
                }
            }
            System.out.println("Not found any Id match your input Id!");
            System.out.println("Please try again!\n");
        }
    }


}
