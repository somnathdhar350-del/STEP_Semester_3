
public class QueueOrder {
    public static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sample1 = {3, 5, 5, 8, 6, 9};
        System.out.println(firstBreak(sample1));

        int[] sample2 = {1, 2, 2, 7};
        System.out.println(firstBreak(sample2));

        int[] custom = {10, 20, 15, 25};
        System.out.println(firstBreak(custom));
    }
}