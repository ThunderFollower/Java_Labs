package main.java.bookstore.controller;


import main.java.bookstore.BookDataClass;
import main.java.bookstore.view.BookView;
import main.java.utils.IInstrument;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public interface IBookControlTarget {
    public BookDataClass[] getBooksByAuthor();

    public BookDataClass[] getBooksByPublisher();

    public BookDataClass[] getBooksPublishedAfterConcreteYear();

    public void sortBooksByPublisher();

    public void executeActionsWithBooks();

    public class BookController implements IBookControlTarget {
        private BookView bookView;
        private BookDataClass[] books = {new BookDataClass("Gerald's game", "Stephen King",
                "qwerty1", 1999, 203, 250),
                new BookDataClass("The Churchill factor", "Boris Johnson",
                        "qwerty2", 2006, 405, 400),
                new BookDataClass("Clean Code", "Robert C. Martin", "qwerty3",
                        2005, 800, 630),
                new BookDataClass("Clean Architecture", "Robert C. Martin", "qwerty3",
                        2006, 965, 700),
                new BookDataClass("Fear and loathing in Las Vegas", "Hunter S. Thompson",
                        "qwerty1", 1993, 176, 200),
                new BookDataClass("The picture of Dorian Gray", "Oscar Wilde", "qwerty1",
                        2001, 220, 140),
                new BookDataClass("Come as you are", "Michael Aserrad", "qwerty2",
                        2008, 478, 330),
                new BookDataClass("1984", "George Orwell", "qwerty1",
                        2012, 147, 120),
                new BookDataClass("Steve Jobs", "Walter Isaacson", "qwerty2",
                        2002, 700, 270),
                new BookDataClass("Necronomicon", "Howard Lovecraft", "qwerty4",
                        1986, 301, 210)
        };

        @Override
        public BookDataClass[] getBooksByAuthor() {
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter name of author: ");
            String authorName = reader.next();
            return Arrays.stream(books).filter(f -> f.author.contains(authorName)).toArray(BookDataClass[]::new);
        }

        @Override
        public BookDataClass[] getBooksByPublisher() {
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter publisher: ");
            String publisher = reader.next();
            return Arrays.stream(books).filter(f -> f.publisher.equals(publisher)).toArray(BookDataClass[]::new);
        }

        @Override
        public BookDataClass[] getBooksPublishedAfterConcreteYear() {
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter year of publish: ");
            final IInstrument.Instrument instrument = new IInstrument.Instrument();
            int yearOfPublish = instrument.inputIntInRange(1900, 2022);
            return Arrays.stream(books).filter(f -> f.yearOfPublish > yearOfPublish).toArray(BookDataClass[]::new);
        }

        @Override
        public void sortBooksByPublisher() {
            Arrays.sort(books, new Comparator<BookDataClass>() {
                public int compare(BookDataClass firstBook, BookDataClass secondBook) {
                    return firstBook.publisher.compareTo(secondBook.publisher);
                }
            });
        }

        @Override
        public void executeActionsWithBooks() {
            final Scanner reader = new Scanner(System.in);
            final BookView bookView = new BookView();
            final IInstrument.Instrument instrument = new IInstrument.Instrument();
            do {
                System.out.println("1 - Show all books\n2 - Get books from concrete author\n" +
                        "3 - Get books from concrete publisher\n" +
                        "4 - Get books that were published after concrete year\n" +
                        "5 - Sort by publisher\nYour choice: ");
                switch (instrument.inputIntInRange(1, 5)) {
                    case 1:
                        bookView.showBooks(books);
                        break;

                    case 2:
                        bookView.showBooks(this.getBooksByAuthor());
                        break;

                    case 3:
                        bookView.showBooks(this.getBooksByPublisher());
                        break;

                    case 4:
                        bookView.showBooks(this.getBooksPublishedAfterConcreteYear());
                        break;

                    case 5:
                        this.sortBooksByPublisher();
                        break;

                    default:
                        break;
                }
                System.out.print("Enter n to stop working with books " +
                        "or any other input to continue\nYour choice: ");
            } while (reader.next().charAt(0) != 'n');
        }
    }

}

