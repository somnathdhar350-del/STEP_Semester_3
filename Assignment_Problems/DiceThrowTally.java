
import java.util.*;

public class DiceThrowTally {
    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            count[roll]++;
        }

        System.out.print("Counts:");
        for (int v = 1; v <= 6; v++) {
            System.out.print(" " + v + ":" + count[v]);
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] sample = {4, 1, 6, 4, 2, 1, 4};
        System.out.println("Sorted: " + Arrays.toString(diceSort(sample)));
        System.out.println();

        int[] custom = {6, 3, 5, 3, 2, 6, 1};
        System.out.println("Sorted: " + Arrays.toString(diceSort(custom)));
    }
}