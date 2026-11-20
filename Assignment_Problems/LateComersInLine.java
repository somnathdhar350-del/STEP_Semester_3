
// Time Complexity: addFirst() -> O(1), addLast() -> O(n)
public class LateComersInLine {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    static Node addLast(Node head, String name) {
        Node newNode = new Node(name);
        if (head == null) return newNode;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    static void printLine(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1
        Node head1 = addLast(null, "Asha");
        head1 = addLast(head1, "Ravi");
        head1 = addFirst(head1, "Neha");
        head1 = addLast(head1, "Kiran");
        head1 = addFirst(head1, "Mohan");
        printLine(head1);

        // Sample 2
        Node head2 = null;
        head2 = addLast(head2, "Pooja");
        head2 = addFirst(head2, "Arun");
        printLine(head2);
    }
}