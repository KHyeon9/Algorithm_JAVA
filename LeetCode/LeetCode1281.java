public class LeetCode1281 {
    // Subtract the Product and Sum of Digits of an Integer
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        String nStr = String.valueOf(n);
        for (int i = 0; i < nStr.length(); i++) {
            int now = nStr.charAt(i) - '0';
            mul *= now;
            sum += now;
        }
        return mul - sum;
    }
}

