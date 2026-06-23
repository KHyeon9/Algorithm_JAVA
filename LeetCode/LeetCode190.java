public class LeetCode190 {
    public int reverseBits(int n) {
        // 2진법으로 변경
        String bin = Integer.toBinaryString(n);
        // 32비트로 만들기
        StringBuilder sb = new StringBuilder();
        sb.repeat("0", 32 - bin.length())
                .append(bin).reverse(); // 뒤집기
        // 10진법으로 다시 변경
        return Integer.parseInt(sb.toString(), 2);
    }
}
