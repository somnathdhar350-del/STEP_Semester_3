package Class_Problems;

import java.util.HashSet;
import java.util.Set;

// Approach 1 (Implemented - HashSet): O(n) time, O(n) space.
// Approach 2 (Brute Force): Nested loops checking all pairs -> O(n^2) time, O(1) space.
// Approach 3 (Sorting + Two Pointers): O(n log n) time, O(1) or O(log n) space.
public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));
    }
}