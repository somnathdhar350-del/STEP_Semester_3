package Class_Problems;

import java.util.Scanner;

// Time Complexity: O(1) (fixed 7 days; O(n) for n days), Space Complexity: O(1)
public class WeeklyRainfallAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rainfall = new double[7];

        for (int i = 0; i < 7; i++) {
            rainfall[i] = sc.nextDouble();
        }

        double total = 0.0;
        int wettestIndex = 0;
        int dryDays = 0;

        System.out.print("Rainfall (mm):");
        for (int i = 0; i < 7; i++) {
            System.out.print(" " + rainfall[i]);
            total += rainfall[i];
            if (rainfall[i] > rainfall[wettestIndex]) {
                wettestIndex = i;
            }
            if (rainfall[i] == 0.0) {
                dryDays++;
            }
        }
        System.out.println();

        double average = total / 7.0;
        System.out.println("Total Rainfall: " + total + " mm");
        System.out.printf("Average Rainfall: %.2f mm%n", average);
        System.out.println("Wettest Day: Day " + (wettestIndex + 1) + " (" + rainfall[wettestIndex] + " mm)");
        System.out.println("Total Dry Days: " + dryDays);
        sc.close();
    }
}