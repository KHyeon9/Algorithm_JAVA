import java.util.*;
import java.io.*;

public class BOJ16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        // 일수마다 알파벳의 누적합을 저장
        int len = line.length();
        int[][] alpaCntArr = new int[26][len + 1];

        for (int i = 0; i < len; i++) {
            // 이전에 카운팅된 누적합을 다시 현재 일수로 가져옴
            for (int alpa = 0; alpa < 26; alpa++) {
                alpaCntArr[alpa][i + 1] = alpaCntArr[alpa][i];
            }
            // 현재 알파벳
            char nowChar = line.charAt(i);
            // 해당 순서의 알파벳이 나왔으므로 증가
            alpaCntArr[nowChar - 'a'][i + 1]++;
        }
        // 입력 받기
        int questCnt = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < questCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 찾을 알파벳과 범위 입력
            char findAlpa = st.nextToken().charAt(0);
            int alpaIdx = findAlpa - 'a';
            int left = Integer.parseInt(st.nextToken());
            // left <= cnt <= right 이므로 ringht + 1
            int right = Integer.parseInt(st.nextToken()) + 1;
            answer.append(alpaCntArr[alpaIdx][right] - alpaCntArr[alpaIdx][left])
                            .append("\n");
        }
        System.out.println(answer);
    }
}
