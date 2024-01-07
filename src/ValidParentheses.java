import java.util.Stack;

// Given a string s, containing just the characters '(', ')', '[', ']', '{', and '}',
// determine if the input string is valid
// An input string is valid is:
//  - Open brackets must be closed by the same types of brackets.
//  - Open brackets must be closed in correct order.
// i.e., Input: s = "{()}" Output: true
//       Input: s = "{]"   Output: false
public class ValidParentheses {
    public static void display(String s) {
        // Prints the input string
        if (s == null) return;
        char[] c = s.toCharArray();
        System.out.print("s = ");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(c[i]);
        }
    }

    public static boolean containsCharacters(String s) {
        // Check if the input string contains the valid characters, i.e., '(', ')', '[', ']', '{', and '}'
        if (s == null) return false;
        boolean found = false;
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (!(c[i] == '(') && !(c[i] == ')') && !(c[i] == '[') && !(c[i] == ']')
                    && !(c[i] == '{') && !(c[i] == '}')) {
                found = false;
            } else {
                found = true;
            }
        }
        return found;
    }

    public static boolean isValid(String s) {
        if (!containsCharacters(s)) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((c == '(' || c == '[' || c == '{')) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if((c == ')' && top == '(') || (c == '}' && top == '{')
                            || (c == ']' && top == '[') ) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "}{";
        System.out.print("Input: "); display(s);
        System.out.println();
        System.out.println("Output " + isValid(s));

        s = "{]";
        System.out.print("Input: "); display(s);
        System.out.println();
        System.out.println("Output " + isValid(s));

        s = "{()";
        System.out.print("Input: "); display(s);
        System.out.println();
        System.out.println("Output " + isValid(s));

        s = "{()}";
        System.out.print("Input: "); display(s);
        System.out.println();
        System.out.println("Output " + isValid(s));
    }
}
