public class LeetCode342 {
    // Power of Four
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        // 나눌수 있을때까지 나누기
        while(n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
