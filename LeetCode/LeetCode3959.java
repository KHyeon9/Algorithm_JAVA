public class LeetCode3959 {
    // Check Good Integer
    public boolean checkGoodInteger(int n) {
        int digitSum = 0, squareSum = 0;

        for (char c : String.valueOf(n).toCharArray()) {
            digitSum += (c - '0');
            int square = (c - '0') * (c - '0');
            squareSum += square;
        }
        return squareSum - digitSum >= 50;
    }
}

