package activity1;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("White Nights", "Fyodor Dostoevsky", "123109312", "1848\n");
        Book book2 = new Book("Beyond Good and Evil: Prelude to a Philosophy of the Future", "Friedrich Nietzsche", "123912392", "1886\n");
        Book book3 = new Book("Notes from Underground", "Fyodor Dostoevsky", "940134182321", "1864\n");
        Book book4 = new Book("The Brothers Karamazov", "Fyodor Dostoevsky", "6581912131", "1880\n");

        System.out.println("\nBook Infos: ");
        book1.printBookInfo();
        book2.printBookInfo();
        book3.printBookInfo();
        book4.printBookInfo();
    }
}
