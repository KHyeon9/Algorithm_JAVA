public class LeetCode796 {
    // Rotate String
    public boolean rotateString(String s, String goal) {
        // 2배로 늘리면 회전된 모든 글자를 확인 가능
        String repeatStr = s.repeat(2);
        // 포함되는지 확인
        return repeatStr.contains(goal);
    }
}
