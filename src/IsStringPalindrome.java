public class IsStringPalindrome {
    // Given a string, the task is to check whether given string is palindrome or not.
    // Input: "madam"
    // Output: true

    public static boolean isPalindrome(String word) {
        //Method 1: Directly checking both ends of the string
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome2(String word) {
        // Method 2: using 'reverse' helper to reverse the string and check if it matches the original
        String reverseWord = reverse(word);
        return word.equals(reverseWord);
    }

    public static String reverse(String word) {
        // Helper method to reverse a string
        char[] newStr = new char[word.length()];
        for (int i = word.length() - 1; i >= 0; i--) {
            newStr[i] = word.charAt(word.length() - 1 - i);
        }
        System.out.print("Reversed word: ");
        System.out.println(newStr);
        return new String(newStr);
    }

    public static void main(String[] args) {
        String word = "Hello";
        System.out.println("Original word: " + word);
        System.out.println("Is palindrome? " + isPalindrome(word));
//        System.out.println("Is palindrome? " + isPalindrome2(word));
    }
}
