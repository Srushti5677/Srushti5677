import java.util.Scanner;

public class InversionCount {

    // Function to count inversions using merge sort
    public static int countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // Helper function that performs merge sort and counts inversions
    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int mid, invCount = 0;
        if (right > left) {
            mid = (right + left) / 2;

            // Count inversions in the left half
            invCount += mergeSortAndCount(arr, left, mid);

            // Count inversions in the right half
            invCount += mergeSortAndCount(arr, mid + 1, right);

            // Count inversions while merging
            invCount += mergeAndCount(arr, left, mid, right);
        }
        return invCount;
    }

    // Function to merge two halves and count inversions
    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        // Copy data to temporary arrays
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < rightArray.length; j++)
            rightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        int invCount = 0;

        // Merge the two arrays and count inversions
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
                // There are mid - i inversions, because all remaining elements in leftArray
                // (from i to mid) are greater than rightArray[j]
                invCount += (mid + 1) - (left + i);
            }
        }

        // Copy remaining elements of leftArray, if any
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray, if any
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }

        return invCount;
    }

    // Main method to test the inversion count with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of elements
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Create an array of size n
        int[] P = new int[n];

        // Prompt user to enter the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            P[i] = scanner.nextInt();
        }

        // Count inversions
        int inversionCount = countInversions(P);
        System.out.println("Number of inversions: " + inversionCount);

        // Close the scanner
        scanner.close();
    }
}