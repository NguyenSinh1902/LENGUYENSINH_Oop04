public class Library {
    void displayBookInfo(Book book){
        System.out.println("Title" + book.title);
        System.out.println("Author" + book.author);
        System.out.println("Publication Year" + book.publicationYear);
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java Basics", "John Smith", 2023);
        Book book2 = new Book("Java 02", "NguyenSinh", 2022);
        Library library = new Library();
        library.displayBookInfo(book1);
        library.displayBookInfo(book2);
    }
}
