package library.model;

import library.util.InputValidator;

public abstract class LibraryResource {
    private int resourceId;
    private String title;
    private String author;
    public static String libraryName = "Smart University Library";
    private static int totalResources = 0;

    protected LibraryResource(int resourceId, String title, String author) {
        setResourceId(resourceId);
        setTitle(title);
        setAuthor(author);
        totalResources++;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        if (!InputValidator.validateResourceId(resourceId)) {
            throw new IllegalArgumentException("Resource ID must be greater than zero.");
        }
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        this.author = author.trim();
    }

    public static int getTotalResources() {
        return totalResources;
    }

    public static void displayTotalResources() {
        System.out.println("Total resources created: " + totalResources);
    }

    protected void printCommonDetails() {
        System.out.println("Resource ID: " + resourceId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Library    : " + libraryName);
    }

    public abstract double calculateFine(int overdueDays);
}
