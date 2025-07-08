import BookStore.*;
import Services.*;

import java.util.List;

public class EBookTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add books
        inventory.addBook(new PaperBook("P001", "Java Unleashed", 2025, 250.0, 5L, true,20.0));   // shippable
        inventory.addBook(new PaperBook("P002", "Algorithms 101", 2023, 220.0, 3L, false,0.0)); // not shippable
        inventory.addBook(new EBook("E001", "Clean Code", 2019, 100.0, "pdf", true));     // send by email
        inventory.addBook(new EBook("E002", "Refactoring", 2020, 120.0, "epub", false));  // not emailed
        inventory.addBook(new ShowcaseBook("S001", "History of Tech", 2025, 0.0));         // demo book

        System.out.println();
        //  Remove outdated books (threshold = 5 years)
        List<Book> outdated = inventory.removeOutdatedBooks(5);
        System.out.println("Outdated books removed:");
        for (Book b : outdated) {
            System.out.println("- " + b.getTitle() + " (ISBN: " + b.getISBN() + ")");
        }

        System.out.println();

        //Buy shippable PaperBook
        try {
            double paid = inventory.buyBook("P001", 2L, "buyer@mail.com", "12 St");
            System.out.println("Paid amount = " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Buy non-shippable PaperBook
        try {
            double paid = inventory.buyBook("P002", 1L, "buyer@mail.com", "34 st");
            System.out.println("Paid amount = " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Buy EBook with email
        try {
            double paid = inventory.buyBook("E001", 1L, "reader@mail.com", null);
            System.out.println("Paid amount = " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Buy EBook without email
        try {
            double paid = inventory.buyBook("E002", 1L, null, null);
            System.out.println("Paid amount = " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Attempt to buy ShowcaseBook
        try {
            inventory.buyBook("S001", 1L, "visitor@mail.com", "Museum Rd");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}