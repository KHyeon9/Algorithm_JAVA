public class LeetCode2427 {
    // Number of Common Factors
    public int commonFactors(int a, int b) {
        int ans = 0;
        int range = Math.min(a, b);
        for (int i = 1; i <= range; i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            };
        }
        return ans;
    }
}

