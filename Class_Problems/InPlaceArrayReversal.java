package Class_Problems;

import java.util.Arrays;

public class InPlaceArrayReversal {
    public static void reverseInPlace(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] tokens = {11, 22, 33, 44};
        reverseInPlace(tokens);
        System.out.println(Arrays.toString(tokens)); // [44, 33, 22, 11]
    }
}