import java.util.Scanner;

public class PostfixSumCalculator {
    public static int[] calculatePostfixSum(int[] fuel) {
        int m = fuel.length; // Length of the input array
        int[] postfixSum = new int[m]; // Array to store the postfix sums

        // Initialize the last element of postfixSum
        postfixSum[m - 1] = fuel[m - 1];

        // Calculate postfix sums from the end to the beginning
        for (int i = m - 2; i >= 0; i--) {
            postfixSum[i] = fuel[i] + postfixSum[i + 1];
        }

        return postfixSum; // Return the resulting array
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of delivery points:");
        int m = scanner.nextInt(); // Read the number of delivery points
        
        int[] fuel = new int[m]; // Create an array of size m
        
        System.out.println("Enter the fuel consumption at each delivery point:");
        for (int i = 0; i < m; i++) {
            fuel[i] = scanner.nextInt(); // Read each fuel consumption value
        }
        
        int[] result = calculatePostfixSum(fuel);
        System.out.println("Postfix Sum of fuel consumption:");
        for (int sum : result) {
            System.out.print(sum + " "); // Output the result
        }
        
        scanner.close(); // Close the scanner
    }
}