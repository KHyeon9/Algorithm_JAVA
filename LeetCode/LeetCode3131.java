import java.util.Arrays;

public class LeetCode3131 {
    // Find the Integer Added to Array I
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
}

