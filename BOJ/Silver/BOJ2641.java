import java.io.*;
import java.util.*;

public class BOJ2641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        // 비교할 셈플 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder originSampleSb = new StringBuilder();
        StringBuilder reverseSampleSb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char move = st.nextToken().charAt(0);
            originSampleSb.append(move);
            // 반대 순서도 저장 (1 -> 3, 2 -> 4, 3 -> 1, 4 -> 2)
            reverseSampleSb.append(reverseMove(move));
        }
        // 시작 위치에 따른 움직이는 순서를 찾기 쉽게하기 위해 * 2
        String originSample = originSampleSb.toString().repeat(2);
        // 반대 순서로 가므로 역방향으로 하고 * 2 저장
        String reverseSample = reverseSampleSb.reverse().toString().repeat(2);
        // 다음 표본수 검사
        int sampleCnt = Integer.parseInt(br.readLine());
        int answer = 0;
        ArrayList<String> sameSample = new ArrayList<>();
        for (int i = 0; i < sampleCnt; i++) {
            st = new StringTokenizer(br.readLine());
            // 빅교할 셈플 받기
            StringBuilder inputSample = new StringBuilder();
            for (int j = 0; j < length; j++) {
                inputSample.append(Integer.parseInt(st.nextToken()));
            }
            // 역방향과 정방향 둘 중 하나라도 같은 모양 만들어지면 저장 및 갯수 증가
            if (originSample.contains(inputSample) || reverseSample.contains(inputSample)) {
                answer++;
                sameSample.add(inputSample.toString());
            }
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for (String line : sameSample) {
            for (char dir : line.toCharArray()) {
                sb.append(dir).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    // 반대 방향으로 변경
    private static char reverseMove(char move) {
        switch (move) {
            case '1': return '3';
            case '2': return '4';
            case '3': return '1';
            default: return '2';
        }
    }
}
