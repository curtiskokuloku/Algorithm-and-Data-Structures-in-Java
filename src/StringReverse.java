import java.util.Stack;

// Reversing a string using a Stack
public class StringReverse {
    public static String reverse(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }
        for (int i = 0; i < s.length(); i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "CURTIS";
        System.out.println("Before reverse: " + s);
        System.out.println("After reverse: " + reverse(s));
    }
}
