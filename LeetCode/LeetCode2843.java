public class LeetCode2843 {
    // Count Symmetric Integers
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;

        for (int num = low; num <= high; num++) {
            String strNum = Integer.toString(num);
            int len = strNum.length();

            if (len % 2 == 1) {
                continue;
            }

            String left = strNum.substring(0, len / 2);
            String right = strNum.substring(len / 2, len);

            int leftSum = 0, rightSum = 0;
            for (int i = 0; i < len / 2; i++) {
                leftSum += left.charAt(i) - '0';
                rightSum += right.charAt(i) - '0';
            }
            if (leftSum == rightSum) cnt++;
        }
        return cnt;
    }
}

