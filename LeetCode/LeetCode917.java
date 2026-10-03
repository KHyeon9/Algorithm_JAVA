import java.util.*;

public class LeetCode917 {
    // Reverse Only Letters
    public String reverseOnlyLetters(String s) {
        char[]  chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty() || Character.isLetter(chars[i])) {
                chars[i] = stack.pop();
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            ans.append(c);
        }
        return ans.toString();
    }
}

