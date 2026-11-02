public class LeetCode3162 {
    // Find the Number of Good Pairs I
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int cnt = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums1[i] % (nums2[j] * k) == 0) cnt++;
            }
        }
        return cnt;
    }
}

