package library.model;

import library.util.InputValidator;

public class Book extends LibraryResource implements Printable {
    private static final double FINE_RATE = 5.0;

    public Book(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {
        if (!InputValidator.validateFineDays(overdueDays)) {
            throw new IllegalArgumentException("Overdue days must be zero or greater.");
        }
        return overdueDays * FINE_RATE;
    }

    @Override
    public void printDetails() {
        printCommonDetails();
        System.out.println("Resource Type: Book");
    }
}
