import java.util.Scanner;

public class FindPalindromeDigit {

    public static int findDigitToRemove(int input1) {
        String number = String.valueOf(input1);
        int n = number.length();

        // Check if the number is already a palindrome
        if (isPalindrome(number)) {
            return -1; // No digit needs to be removed
        }

        // Check which digit to remove to form a palindrome
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(number);
            sb.deleteCharAt(i);
            if (isPalindrome(sb.toString())) {
                return Character.getNumericValue(number.charAt(i));
            }
        }
        return -1; // If no digit can form a palindrome by removing it
    }

    // Helper method to check if a string is palindrome
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner();
	int num = scanner.nextInt();
	System.out.println(findDigitToRemove(num));
    }
}
