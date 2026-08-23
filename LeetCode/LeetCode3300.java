public class LeetCode3300 {
    // Minimum Element After Replacement With Digit Sum
    public int minElement(int[] nums) {
        int answer = Integer.MAX_VALUE;

        for (int num : nums) {
            int nowSum = 0;
            for (char ch : String.valueOf(num).toCharArray()) {
                nowSum += ch - '0';
            }
            answer = Math.min(answer, nowSum);
        }
        return answer;
    }
}
