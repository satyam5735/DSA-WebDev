package SigmaBatch.LiveSessions.Session14;

//Question - You are given a number (eg - 2019) convert it into a String of English like "two zero one nine". Use recursive function to solve the problem. NOTE - The digits of the number will only be in the range 0-9 and the last digit of a number can't be 0.

public class NumberToWords {

    // Array to map digits to words
    static String[] digitWords = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };

    // Recursive function to print words for each digit
    public static void convertToWords(int number) {
        // Base case: if number becomes 0, stop
        if (number == 0) {
            return;
        }

        // Recursive call: process all digits except the last one
        convertToWords(number / 10);

        // Print the last digit
        int digit = number % 10;
        System.out.print(digitWords[digit] + " ");
    }

    public static void main(String[] args) {
        int number = 2019;

        System.out.print("Number in words: ");
        convertToWords(number);
    }
}
// The digitWords array maps digits 0 through 9 to their word equivalents.
// This helps convert each digit in the number into its English form.

// The convertToWords method uses recursion to break down the number digit by digit.
// It first recursively calls itself with number / 10 to strip off the last digit,
// allowing us to reach and process the most significant digit first.

// Once the base case is hit (number == 0), the recursion stops,
// and the stack begins to unwind. As each recursive call completes,
// it prints the corresponding word for the digit at that level.

// For example, for input 2019:
// - The recursion first drills down to 2
// - Then prints "two zero one nine" as the call stack unwinds

// This approach prints the digits in correct left-to-right order,
// even though we're recursively moving from high to low significance.




// NOTE: The correct order is:
//    convertToWords(number / 10);      // Go deeper into recursion first
//    int digit = number % 10;          // Then process and print digit

// But if you reverse it like this:
//    int digit = number % 10;
//    convertToWords(number / 10);

// Here's what happens:
// 1. You extract the last digit first, starting with the least significant one.
// 2. Then you recurse to the left side of the number, going toward the most significant digit.
// 3. As a result, when the recursion unwinds, the **last digit gets printed first**.
// 4. This reverses the intended order and prints the number in reverse.
//    Example: for 2019 → output becomes "nine one zero two" instead of "two zero one nine"

// In summary: To print digits from **left to right**, always recurse first (divide by 10),
// and then process the digit (mod 10) after the recursive call.
