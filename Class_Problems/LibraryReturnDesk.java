package Class_Problems;

// Time Complexity: RETURN -> O(1), SHELVE -> O(1), WAIT -> O(1), SERVE -> O(1)
public class LibraryReturnDesk {
    static class BookStack {
        private final String[] pile = new String[3];
        private int top = -1;

        void returnBook(String book) {
            if (top == pile.length - 1) {
                System.out.println(book + " rejected: pile is full");
            } else {
                pile[++top] = book;
                System.out.println(book + " placed on pile");
            }
        }

        void shelveBook() {
            if (top == -1) {
                System.out.println("pile is empty");
            } else {
                System.out.println("shelved " + pile[top--]);
            }
        }
    }

    static class StudentQueue {
        private final String[] line = new String[3];
        private int front = 0, rear = 0, size = 0;

        void waitStudent(String student) {
            if (size == line.length) {
                System.out.println(student + " rejected: line is full");
            } else {
                line[rear] = student;
                rear = (rear + 1) % line.length;
                size++;
                System.out.println(student + " joined the line");
            }
        }

        void serveStudent() {
            if (size == 0) {
                System.out.println("no one waiting");
            } else {
                System.out.println("served " + line[front]);
                front = (front + 1) % line.length;
                size--;
            }
        }
    }

    public static void main(String[] args) {
        BookStack stack = new BookStack();
        StudentQueue queue = new StudentQueue();

        String[] commands = {
            "RETURN B1", "RETURN B2", "RETURN B3", "RETURN B4",
            "WAIT Asha", "WAIT Ravi", "SHELVE", "SERVE",
            "SHELVE", "SHELVE", "SHELVE", "SERVE", "SERVE"
        };

        for (String cmd : commands) {
            String[] parts = cmd.split(" ");
            switch (parts[0]) {
                case "RETURN":
                    stack.returnBook(parts[1]);
                    break;
                case "SHELVE":
                    stack.shelveBook();
                    break;
                case "WAIT":
                    queue.waitStudent(parts[1]);
                    break;
                case "SERVE":
                    queue.serveStudent();
                    break;
            }
        }
    }
}