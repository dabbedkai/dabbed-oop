package activity1;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("White Nights", "Fyodor Dostoevsky", "123109312", "1848");
        book1.printBookInfo();

        Book book2 = new Book("Beyond Good and Evil: Prelude to a Philosophy of the Future", "Friedrich Nietzsche", "123912392", "1886");
        book2.printBookInfo();
    }
}
