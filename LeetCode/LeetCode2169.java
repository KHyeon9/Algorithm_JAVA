public class LeetCode2169 {
    // Count Operations to Obtain Zero
    public int countOperations(int num1, int num2) {
        int cnt = 0;
        while (num1 > 0) {
            cnt++;
            if (num1 >= num2) {
                num1 -= num2;
            } else  {
                num2 -= num1;
            }
        }
        return cnt;
    }
}

