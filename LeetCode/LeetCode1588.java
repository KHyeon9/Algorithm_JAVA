public class LeetCode1588 {
    // Sum of All Odd Length Subarrays
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int res = 0;

        for (int i = 1; i < len; i += 2) {
            for (int j = 0; j < len - i; j++) {
                for (int k = j; k < j + i; k++) {
                    res += arr[k];
                }
            }
        }
        return res;
    }
}

