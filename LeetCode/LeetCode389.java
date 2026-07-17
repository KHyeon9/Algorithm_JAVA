public class LeetCode389 {
    // Power of Two
    public boolean isPowerOfTwo(int n) {
        // 0이하 확인
        if (n <= 0) return false;
        // 2로 계속 나누어서 확인
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
