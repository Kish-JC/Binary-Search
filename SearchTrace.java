
import java.util.Arrays;
import java.util.Scanner;

public class SearchTrace {

    public static int bSearch(int[] arr, int target, int low, int high) {

        System.out.println("binarySearch(" + low + ", " + high + ", " + target + ")");

        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        System.out.println("   mid = " + mid + ", arr[mid] = " + arr[mid]);

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return bSearch(arr, target, low, mid - 1);
        }

        return bSearch(arr, target, mid + 1, high);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        System.out.print("Enter the target value to search: ");
        int target = sc.nextInt();

        int result = bSearch(numbers, target, 0, numbers.length - 1);

        if (result == -1) {
            System.out.println("Target not found.");
            System.out.println("Index: -1");
        } else {
            System.out.println("Target found.");
            System.out.println("Index: " + result);
        }

        sc.close();
    }
}