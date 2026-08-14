package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;

public class LibraryMain {
    public static void main(String[] args) {
        LibraryResource[] resources = new LibraryResource[5];
        resources[0] = new Book(1, "Introduction to Algorithms", "Thomas H. Cormen");
        resources[1] = new Book(2, "Clean Code", "Robert C. Martin");
        resources[2] = new DigitalResource(3, "Java Programming Tutorial", "Oracle");
        resources[3] = new DigitalResource(4, "Design Patterns Guide", "Erich Gamma");
        resources[4] = new Book(5, "Database System Concepts", "Abraham Silberschatz");

        System.out.println("Library: " + LibraryResource.libraryName);
        System.out.println("\n");

        int[] overdueDays = {4, 0, 3, 2, 5};
        double totalFine = 0;

        for (int i = 0; i < resources.length; i++) {
            LibraryResource resource = resources[i];
            resource.printDetails();
            double fine = resource.calculateFine(overdueDays[i]);
            totalFine += fine;
            System.out.println("Overdue Days : " + overdueDays[i]);
            System.out.println("Fine Amount  : Rs. " + String.format("%.2f", fine));
            
        }

        System.out.println("Total Fine for all overdue resources: Rs. " + String.format("%.2f", totalFine));
        LibraryResource.displayTotalResources();
    }
}
