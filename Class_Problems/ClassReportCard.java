package Class_Problems;

import java.util.Scanner;

// Time Complexity: Best Case -> O(n), Worst Case -> O(n^2)
public class ClassReportCard {
    static class Student {
        private String name;
        private int m1, m2, m3;

        Student(String name) {
            this.name = name;
        }

        boolean setMarks(int a, int b, int c) {
            if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
                return false;
            }
            this.m1 = a;
            this.m2 = b;
            this.m3 = c;
            return true;
        }

        int getTotal() {
            return m1 + m2 + m3;
        }

        double getAverage() {
            return getTotal() / 3.0;
        }

        char getGrade() {
            double avg = getAverage();
            if (avg >= 80) return 'A';
            if (avg >= 70) return 'B';
            if (avg >= 60) return 'C';
            if (avg >= 40) return 'D';
            return 'F';
        }

        @Override
        public String toString() {
            return String.format("%s total=%d avg=%.2f grade=%c", name, getTotal(), getAverage(), getGrade());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] accepted = new Student[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Student s = new Student(name);
            if (s.setMarks(a, b, c)) {
                accepted[count++] = s;
            } else {
                System.out.println(name + " skipped: marks must be 0 to 100");
            }
        }

        int passes = 0;
        for (int i = 0; i < count - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < count - 1 - i; j++) {
                if (accepted[j].getTotal() < accepted[j + 1].getTotal()) {
                    Student temp = accepted[j];
                    accepted[j] = accepted[j + 1];
                    accepted[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + accepted[i]);
        }
        System.out.println("Sorted in " + passes + " passes");
        sc.close();
    }
}