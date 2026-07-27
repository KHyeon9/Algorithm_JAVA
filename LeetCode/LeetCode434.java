public class LeetCode434 {
    // Number of Segments in a String
    public int countSegments(String s) {
        // 앞뒤 공백 제거
        s = s.trim();
        // 빈 문자열 처리
        if (s.isEmpty()) return 0;
        return s.split("\\s+").length;
    }
}
