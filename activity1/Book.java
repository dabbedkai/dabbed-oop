package activity1;

public class Book {

    String title;
    String author;
    String isbn;
    String publicationDate;

    public Book(String bookTitle, String bookAuthor, String bookIsbn, String bookPublicationDate) {
        title = bookTitle;
        author = bookAuthor;
        isbn = bookIsbn;
        publicationDate = bookPublicationDate;
    }

    public Book() {
    }

    public void printBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Publication Date: " + publicationDate);
    }
}
