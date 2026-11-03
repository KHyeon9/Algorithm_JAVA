public class LeetCode1979 {
    // Find Greatest Common Divisor of Array
    public int findGCD(int[] nums) {
        int maxNum = 0, minNum = 1000;

        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }

        return getGcd(minNum, maxNum);
    }

    private int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return getGcd(b, a % b);
    }
}

