import java.math.BigInteger;

public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        // BigInteger로 변환
        BigInteger bigNum1 = new BigInteger(num1);
        BigInteger bigNum2 = new BigInteger(num2);
        // 문자열로 변경하여 반환
        return String.valueOf(bigNum1.add(bigNum2));
    }
}
