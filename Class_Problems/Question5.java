import java.util.Scanner;

public class Question5 {

    static int[] rotateArray(int[] nums, int k) {

        k = k % nums.length;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int newIndex = (i + k) % nums.length;
            result[newIndex] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);

        for (int value : result) {
            System.out.print(value + " ");
        }
        sc.close();
    }
}