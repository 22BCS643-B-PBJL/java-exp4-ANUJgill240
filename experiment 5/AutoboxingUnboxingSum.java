import java.util.ArrayList;
import java.util.List;

public class AutoboxingUnboxingSum {
    public static void main(String[] args) {
        // List of string representations of numbers
        String[] numberStrings = {"10", "20", "30", "40", "50"};
        
        // Convert string array to list of Integers
        List<Integer> numbers = parseStringsToIntegers(numberStrings);
        
        // Calculate sum using autoboxing and unboxing
        int sum = calculateSum(numbers);
        
        // Output result
        System.out.println("Sum: " + sum);
    }

    // Method to parse strings into Integer objects
    public static List<Integer> parseStringsToIntegers(String[] strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : strings) {
            numbers.add(Integer.parseInt(str)); // Autoboxing
        }
        return numbers;
    }

    // Method to calculate sum using unboxing
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing
        }
        return sum;
    }
}
