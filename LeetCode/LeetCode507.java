public class LeetCode507 {
    // Perfect Number
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        // 약수를 구해서 총합 구하기
        for (int i = 1; i <= num / 2 ; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}
