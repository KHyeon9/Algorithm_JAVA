import java.io.*;
import java.util.*;

public class BOJ25400 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        // 숫자 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }
        // 뺄 숫자 계산
        int answer = 0, now = 1;
        for (int i = 0; i < cnt; i++) {
            // 현재 값과 다르면 넘어감
            if (nums[i] != now) {
                continue;
            }
            // 맞는 수이므로 answer + 1하고 다름 수로 변경
            answer++;
            now++;
        }
        System.out.println(cnt - answer);
    }
}
