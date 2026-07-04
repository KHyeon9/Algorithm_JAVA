public class LeetCode806 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] answer = new int[2];
        // 첫줄로 셋팅
        answer[0] = 1;

        for (char c : s.toCharArray()) {
            // 현재 문자 넓이 확인
            int nowWith = widths[c - 'a'];
            // 100 픽셀을 초과하는 경우
            if (answer[1] + nowWith > 100) {
                // 새로운 행으로 넘어감
                answer[0]++;
                // 현재 문자 넓이로 변경
                answer[1] = nowWith;
                continue;
            }
            // 100픽셀 이하인 경우 현재 넓이 더하기
            answer[1] += nowWith;
        }
        return answer;
    }
}
