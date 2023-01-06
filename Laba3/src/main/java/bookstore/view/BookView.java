package main.java.bookstore.view;

import main.java.bookstore.BookDataClass;

public class BookView {
    public void showBooks(BookDataClass[] books) {
        if (books.length == 0) {
            System.out.println("There are no books");
        } else {
            for (BookDataClass currentBook : books) {
                System.out.println(currentBook.toString() + "\n");
            }
        }
    }
}
