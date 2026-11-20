
import java.util.Arrays;

public class PrizeTable {
    public static int prizeTable(int[] marks) {
        int n = marks.length;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[] sample1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(sample1);
        System.out.println(Arrays.toString(sample1) + " swaps = " + swaps1);

        int[] sample2 = {80, 70, 60};
        int swaps2 = prizeTable(sample2);
        System.out.println(Arrays.toString(sample2) + " swaps = " + swaps2);

        int[] custom = {50, 85, 70, 95, 65};
        int swaps3 = prizeTable(custom);
        System.out.println(Arrays.toString(custom) + " swaps = " + swaps3);
    }
}