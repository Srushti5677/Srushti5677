import java.util.Scanner;

public class PrefixSumCalculator {
    public static int[] calculatePrefixSum(int[] sales) {
        int n = sales.length; // Length of the input array
        int[] prefixSum = new int[n]; // Array to store the prefix sums

        // Initialize the first element of prefixSum
        prefixSum[0] = sales[0];

        // Calculate prefix sums from the start to the end
        for (int i = 1; i < n; i++) {
            prefixSum[i] = sales[i] + prefixSum[i - 1];
        }

        return prefixSum; // Return the resulting array
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of hours in a day:");
        int n = scanner.nextInt(); // Read the number of hours
        
        int[] sales = new int[n]; // Create an array of size n
        
        System.out.println("Enter the sales amount for each hour:");
        for (int i = 0; i < n; i++) {
            sales[i] = scanner.nextInt(); // Read each sales amount
        }
        
        int[] result = calculatePrefixSum(sales);
        System.out.println("Prefix Sum of sales amounts:");
        for (int sum : result) {
            System.out.print(sum + " "); // Output the result
        }
        
        scanner.close(); // Close the scanner
    }
}