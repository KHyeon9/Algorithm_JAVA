public class LeetCode1678 {
    // Goal Parser Interpretation
    public String interpret(String command) {
        return command
                .replace("()", "o")
                .replace("(al)", "al");
    }
}

