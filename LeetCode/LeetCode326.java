public class LeetCode326 {
    // Power of Three
    public boolean isPowerOfThree(int n) {
        // 0이하 처리
        if (n <= 0) return false;
        // 3으로 나눌 수 있을때 까지 반복
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
