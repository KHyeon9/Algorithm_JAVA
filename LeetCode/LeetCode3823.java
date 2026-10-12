import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode3823 {
    // Reverse Letters Then Special Characters in a String
    public String reverseByType(String s) {
        Deque<Character> deq1 = new ArrayDeque<>();
        Deque<Character> deq2 = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                deq1.push(c);
            } else {
                deq2.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(deq1.pop());
            } else {
                sb.append(deq2.pop());
            }
        }
        return sb.toString();
    }
}

