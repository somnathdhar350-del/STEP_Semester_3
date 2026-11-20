
// Time Complexity: build() -> O(n), printRoute() -> O(n)
public class BusRouteStops {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node build(String[] stops) {
        if (stops == null || stops.length == 0) return null;
        Node head = new Node(stops[0]);
        Node curr = head;
        for (int i = 1; i < stops.length; i++) {
            curr.next = new Node(stops[i]);
            curr = curr.next;
        }
        return head;
    }

    static void printRoute(Node head) {
        if (head == null) return;
        Node curr = head;
        int count = 0;
        String first = head.data;
        String last = head.data;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            last = curr.data;
            count++;
            curr = curr.next;
        }
        System.out.println("null");
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        String[] sample1 = {"Tambaram", "Guindy", "TNagar", "Central"};
        printRoute(build(sample1));

        String[] sample2 = {"Potheri"};
        printRoute(build(sample2));
    }
}