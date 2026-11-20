package Class_Problems;
import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n) average time using a HashSet.
// Space Complexity: O(n) for storing seen transaction IDs.
// Alternative: Sort the array in-place (O(n log n) time, O(1) or O(log n) space) and check adjacent elements.
// Trade-off: Sorting saves memory but increases runtime, which is less suitable for time-sensitive nightly batches.
public class TransactionDuplicateCheck {
    public static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] batch1 = {"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"};
        String[] batch2 = {"TXN2001", "TXN2002", "TXN2003"};
        System.out.println(hasDuplicate(batch1));
        System.out.println(hasDuplicate(batch2));
    }
}