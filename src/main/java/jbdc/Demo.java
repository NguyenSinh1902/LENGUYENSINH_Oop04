package jbdc; // (nếu bạn muốn chuẩn, đổi thành 'jdbc')

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo {
    // Thông số kết nối
    private static final String URL  =
            "jdbc:mysql://localhost:3306/lib?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "Passw0rd";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
                if (conn == null) {
                    System.out.println("Could not connect to database");
                    return;
                }
                System.out.println("Connected to database");

                String choice;
                do {
                    System.out.println("\n===== MENU =====");
                    System.out.println("1. Select all books");
                    System.out.println("2. Insert a book");
                    System.out.println("0. Exit");
                    System.out.print("Enter choice: ");
                    choice = scanner.nextLine().trim();

                    switch (choice) {
                        case "1":
                            getAllBooks(conn);
                            break;
                        case "2":
                            insertBook(conn, scanner);
                            break;
                        case "0":
                            System.out.println("Bye!");
                            break;
                        default:
                            System.out.println("Invalid choice, try again.");
                    }
                } while (!"0".equals(choice));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // SELECT * FROM books
    private static void getAllBooks(Connection conn) {
        String selectQuery = "SELECT book_id, author_id, book_name FROM books ORDER BY book_id";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {

            System.out.println("\nbook_id\tauthor_id\tbook_name");
            while (rs.next()) {
                int bookId   = rs.getInt("book_id");
                int authorId = rs.getInt("author_id");
                String name  = rs.getString("book_name");
                System.out.println(bookId + "\t\t" + authorId + "\t\t" + name);
            }
        } catch (Exception ex) {
            System.out.println("Select failed: " + ex.getMessage());
        }
    }

    // INSERT INTO books (book_name, author_id) VALUES (?, ?)
    private static void insertBook(Connection conn, Scanner scanner) throws Exception {
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();

        System.out.print("Enter author ID: ");
        int authorId = Integer.parseInt(scanner.nextLine());

        String insertQuery = "INSERT INTO books (book_name, author_id) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            stmt.setString(1, bookName);
            stmt.setInt(2, authorId);

            int rowsAffected = stmt.executeUpdate(insertQuery);
            if (rowsAffected > 0) {
                System.out.println("A new book was inserted successfully!");
            }
        } catch (Exception ex) {
            throw new Exception("Can not insert book: " + ex.getMessage());
        }
    }

}
