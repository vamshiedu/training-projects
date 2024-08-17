import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}

class FictionBook extends Book {
    private String genre;

    public FictionBook(String title, String author, String isbn, String genre) {
        super(title, author, isbn);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + " [Genre: " + genre + "]";
    }
}

class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook(String title, String author, String isbn, String subject) {
        super(title, author, isbn);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + " [Subject: " + subject + "]";
    }
}

class Member {
    private String name;
    private ArrayList<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "Member: " + name + ", Borrowed Books: " + borrowedBooks;
    }
}

class Librarian {
    private Map<String, Book> bookCatalog;
    ArrayList<Member> members;

    public Librarian() {
        this.bookCatalog = new HashMap<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookCatalog.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        bookCatalog.remove(isbn);
    }

    public Book searchBook(String isbn) {
        return bookCatalog.get(isbn);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void issueBook(String isbn, Member member) {
        Book book = searchBook(isbn);
        if (book != null) {
            member.borrowBook(book);
            removeBook(isbn);
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String isbn, Member member) {
        // Find the book in the member's borrowed books list
        Book book = null;
        for (Book b : member.getBorrowedBooks()) {
            if (b.getIsbn().equals(isbn)) {
                book = b;
                break;
            }
        }

        if (book != null) {
            member.returnBook(book);
            addBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found in member's borrowed books.");
        }
    }

    public void displayStatus() {
        System.out.println("Book Catalog: " + bookCatalog.values());
        System.out.println("Members: " + members);
    }
}

public class LMS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Librarian librarian = new Librarian();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Status");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book type (1 for Fiction, 2 for Non-Fiction): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        librarian.addBook(new FictionBook(title, author, isbn, genre));
                    } else if (type == 2) {
                        System.out.print("Enter subject: ");
                        String subject = scanner.nextLine();
                        librarian.addBook(new NonFictionBook(title, author, isbn, subject));
                    }
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    librarian.registerMember(new Member(name));
                    System.out.println("Member registered successfully.");
                    break;

                case 3:
                    System.out.print("Enter ISBN of the book to issue: ");
                    String issueIsbn = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String issueName = scanner.nextLine();
                    Member issueMember = findMember(librarian, issueName);
                    if (issueMember != null) {
                        librarian.issueBook(issueIsbn, issueMember);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String returnName = scanner.nextLine();
                    Member returnMember = findMember(librarian, returnName);
                    if (returnMember != null) {
                        librarian.returnBook(returnIsbn, returnMember);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 5:
                    librarian.displayStatus();
                    break;

                case 6:
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static Member findMember(Librarian librarian, String name) {
        for (Member member : librarian.members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }
}