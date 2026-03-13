import java.io.*;
import java.util.*;

public class BOJ27951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        // 행거 위치 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer>[] hangerPos = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            hangerPos[i] = new ArrayList<>();
        }
        // 해당 행거의 위치 저장
        for (int i = 0; i < cnt; i++) {
            int hanger = Integer.parseInt(st.nextToken());
            hangerPos[hanger].add(i);
        }
        // 상의와 하의 받기
        st = new StringTokenizer(br.readLine());
        char[] answer = new char[cnt];
        int upCnt = Integer.parseInt(st.nextToken());
        int downCnt = Integer.parseInt(st.nextToken());
        br.close();
        // 상의 걸기
        for (int pos : hangerPos[1]) {
            answer[pos] = 'U';
            upCnt--;
        }
        // 하의 걸기
        for (int idx : hangerPos[2]) {
            answer[idx] = 'D';
            downCnt--;
        }
        // 공용 행거에 걸기
        for (int pos : hangerPos[3]) {
            if (upCnt > 0) {
                answer[pos] = 'U';
                upCnt--;
            } else if (downCnt > 0) {
                answer[pos] = 'D';
                downCnt--;
            }
        }
        // 다 걸수 있는지 확인 및 출력
        if (upCnt == 0 && downCnt == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("YES").append("\n");
            for (char ch : answer) {
                sb.append(ch);
            }
            System.out.println(sb);
        } else {
            System.out.println("No");
        }
    }
}
