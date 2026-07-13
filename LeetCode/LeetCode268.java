public class LeetCode268 {
    // Missing Number
    public int missingNumber(int[] nums) {
        // 나온 숫자 체크
        boolean[] checkNums = new boolean[nums.length + 1];
        for (int num : nums) {
            checkNums[num] = true;
        }
        // 나오지 않은 숫차 찾기
        for (int i = 1; i <= checkNums.length; i++) {
            if (!checkNums[i]) return i;
        }
        return 0;
    }
}
