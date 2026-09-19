public class LeetCode1688 {
    // Count of Matches in Tournament
    public static int numberOfMatches(int n) {
        int ans = 0;
        while (true) {
            ans += n / 2;
            if (n <= 1) break;
            n = (n - 1) / 2 + 1;
        }
        return ans;
    }
}

