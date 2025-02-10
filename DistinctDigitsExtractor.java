import java.util.*;

public class DistinctDigitsExtractor {
    public static List<Integer> getDistinctSortedDigits(int[] N) {
        // Use a HashSet to store distinct digits
        Set<Integer> digitSet = new HashSet<>();

        // Iterate through each number in the array
        for (int number : N) {
            // Convert the number to a string to extract digits
            String numStr = String.valueOf(Math.abs(number)); // Use abs to handle negative numbers
            for (char digitChar : numStr.toCharArray()) {
                // Add the digit to the set
                digitSet.add(Character.getNumericValue(digitChar));
            }
        }

        // Convert the set to a list
        List<Integer> distinctDigits = new ArrayList<>(digitSet);
        // Sort the list
        Collections.sort(distinctDigits);

        return distinctDigits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of integers you want to input:");
        int k = scanner.nextInt(); // Read the number of integers
        
        int[] N = new int[k]; // Create an array of size k
        
        System.out.println("Enter " + k + " integers:");
        for (int i = 0; i < k; i++) {
            N[i] = scanner.nextInt(); // Read each integer
        }
        
        List<Integer> result = getDistinctSortedDigits(N);
        System.out.println("Distinct sorted digits: " + result); // Output the result
        
        scanner.close(); // Close the scanner
    }
}