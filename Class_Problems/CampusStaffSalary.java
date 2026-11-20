package Class_Problems;

import java.util.Scanner;

// Time Complexity: O(n)
public class CampusStaffSalary {
    static class Staff {
        String name;
        double baseSalary;

        Staff(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        double getBonus() {
            return 0.0;
        }

        String getType() {
            return "Staff";
        }
    }

    static class Teacher extends Staff {
        Teacher(String name, double baseSalary) {
            super(name, baseSalary);
        }

        @Override
        double getBonus() {
            return 5000.0;
        }

        @Override
        String getType() {
            return "Teacher";
        }
    }

    static class LabAssistant extends Staff {
        LabAssistant(String name, double baseSalary) {
            super(name, baseSalary);
        }

        @Override
        double getBonus() {
            return 2000.0;
        }

        @Override
        String getType() {
            return "LabAssistant";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Staff[] staffList = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double base = sc.nextDouble();

            if (type.equalsIgnoreCase("Teacher")) {
                staffList[i] = new Teacher(name, base);
            } else if (type.equalsIgnoreCase("LabAssistant")) {
                staffList[i] = new LabAssistant(name, base);
            } else {
                staffList[i] = new Staff(name, base);
            }
        }

        double grandTotal = 0.0;
        for (Staff s : staffList) {
            double bonus = s.getBonus();
            double total = s.baseSalary + bonus;
            grandTotal += total;
            System.out.println(s.name + " (" + s.getType() + "): base " + s.baseSalary
                    + ", bonus " + bonus + ", total " + total);
        }
        System.out.println("Grand Total Salary: " + grandTotal);
        sc.close();
    }
}