public class LeetCode551 {
    // Student Attendance Record I
    public boolean checkRecord(String s) {
        int maxContiLateCnt = 0;
        int contiLateCnt = 0;
        int absenceCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            // 현재 지각 횟수 증가
            if (s.charAt(i) == 'L') {
                contiLateCnt++;
                continue;
            }
            // 연속 지각일이 지금이 더 큰경우
            if (contiLateCnt > maxContiLateCnt) {
                maxContiLateCnt = contiLateCnt;
            }
            contiLateCnt = 0;
            if (s.charAt(i) == 'A') absenceCnt++;

        }
        // 한번 더 검사
        if (contiLateCnt > maxContiLateCnt) {
            maxContiLateCnt = contiLateCnt;
        }
        return absenceCnt < 2 && maxContiLateCnt < 3;
    }
}
