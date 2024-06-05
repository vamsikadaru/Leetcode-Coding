import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean oddCountFound = false;

        // Calculate the longest palindrome length
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1; // Add the even part
                oddCountFound = true;
            }
        }

        // If there was any character with an odd count, we can add one to the length
        if (oddCountFound) {
            length += 1;
        }

        return length;
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "abccccdd";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + longestPalindrome(s1)); // Output: 7

        // Example 2
        String s2 = "a";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + longestPalindrome(s2)); // Output: 1

        // Example 3
        String s3 = "Aa";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + longestPalindrome(s3)); // Output: 1
    }
}
