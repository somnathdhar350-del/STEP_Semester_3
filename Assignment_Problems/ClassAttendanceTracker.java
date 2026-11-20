
public class ClassAttendanceTracker {
    // Returns {presentDays, longestStreak}
    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }
        return new int[]{present, longestStreak};
    }

    public static void main(String[] args) {
        int[] res1 = attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        System.out.println("Present: " + res1[0] + ", Longest streak: " + res1[1]); // Present: 6, Longest streak: 3

        int[] res2 = attendanceSummary(new int[]{0, 0, 0});
        System.out.println("Present: " + res2[0] + ", Longest streak: " + res2[1]); // Present: 0, Longest streak: 0
    }
}