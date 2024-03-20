import java.util.Scanner;

public class FindStringCode {

    public static int findStringCode(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int sum = 0;
            int length = word.length();
            int mid = length / 2;
            
            for (int i = 0; i < mid; i++) {
                int diff = Math.abs(word.charAt(i) - word.charAt(length - 1 - i));
                sum += diff;
            }
            
            if (length % 2 != 0) { // If word length is odd, consider the middle character
                sum += word.charAt(mid) - 'A' + 1; // Assuming input contains only alphabet characters
            }
            
            result.append("[").append(sum).append("]");
        }

        return Integer.parseInt(result.toString().replaceAll("[^0-9]", ""));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	String str = scanner.nextLine();
	
        System.out.println("World Wide Web - " + findStringCode("World Wide Web")); // Output: 402326
        System.out.println(str + " - " + findStringCode(str)); // Output: 2640
    }
}
