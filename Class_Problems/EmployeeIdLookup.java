package Class_Problems;

import java.util.HashMap;
import java.util.Map;

// getDepartment Time Complexity: O(1) average.
// Space Cost: O(n) to store the HashMap.
// Justification: Building the map takes O(n) once, which is amortized over frequent daily queries while updates are rare.
public class EmployeeIdLookup {
    public static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        String[][] records = {
            {"E245", "Finance"},
            {"E110", "Engineering"},
            {"E390", "Marketing"},
            {"E101", "Engineering"}
        };
        Map<String, String> lookup = buildLookup(records);
        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}