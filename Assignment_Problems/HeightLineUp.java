
import java.util.Arrays;

public class HeightLineUp {
    public static void lineUp(int[] heights) {
        int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(heights));
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] sample1 = {4, 2, 5, 1};
        lineUp(sample1);
        System.out.println();

        int[] sample2 = {1, 3, 2, 4};
        lineUp(sample2);
        System.out.println();

        int[] custom = {10, 8, 12, 6, 9};
        lineUp(custom);
    }
}