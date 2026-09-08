package library.model;

import library.util.InputValidator;

public class DigitalResource extends LibraryResource implements Printable {
    private static final double FINE_RATE = 2.0;

    public DigitalResource(int resourceId, String title, String author) {
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
        System.out.println("Resource Type: Digital Resource");
    }
}
