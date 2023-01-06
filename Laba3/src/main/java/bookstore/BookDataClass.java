package main.java.bookstore;

public class BookDataClass {
    public String bookName;
    public String author;
    public String publisher;
    public int yearOfPublish;
    public int numberOfPages;
    public float price;

    public BookDataClass(String bookName, String author, String publisher, int yearOfPublish, int numberOfPages, float price) {
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAuthor: %s\nPublisher: %s\n" + "Year of publish: %d\nNumber of pages: %d\nPrice: %f", this.bookName, this.author, this.publisher, this.yearOfPublish, this.numberOfPages, this.price);
    }
}
