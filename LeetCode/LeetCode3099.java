public class LeetCode3099 {
    // Harshad Number
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        String xStr = String.valueOf(x);
        int sum = 0;

        for (char ch : xStr.toCharArray()) {
            sum += ch - '0';
        }
        return x % sum == 0 ? sum : -1;
    }
}

