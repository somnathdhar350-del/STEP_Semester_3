package Class_Problems;

import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate calculateDueDate(LocalDate currentDate);
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "");

            switch (type) {
                case "BOOK":
                    items.add(new Book(title));
                    break;
                case "DVD":
                    items.add(new DVD(title));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(title));
                    break;
            }
        }

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate(currentDate));
        }
        sc.close();
    }
}