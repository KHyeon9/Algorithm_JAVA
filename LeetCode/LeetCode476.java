public class LeetCode476 {
    public int findComplement(int num) {
        // 마스킹할 2진수를 구하기 위해 2진법으로 변환
        String binary = Integer.toBinaryString(num);
        // 마스크 문자열 생성
        String mask = "1".repeat(binary.length());
        // 정수로 변환
        int maskInt = Integer.parseInt(mask, 2);
        // XOR로 결과 반환
        return num^maskInt;
    }
}
