public class LeetCode1385 {
    // Find the Distance Value Between Two Arrays
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;

        for (int num1 : arr1) {
            boolean flag = true;
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    flag = false;
                    break;
                }
            }
            cnt += flag ? 1 : 0;
        }

        return cnt;
    }
}

