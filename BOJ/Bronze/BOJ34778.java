import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34778 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] levels = new int[4];
        // 제작한 난이도의 문제 수 계산
        for (int i = 0; i < 10; i++) {
            int level = Integer.parseInt(st.nextToken());
            levels[level - 1]++;
        }

        int result = 0;
        // 만들어지 않은 난이도 문제 확인
        for (int level : levels) {
            result += level == 0 ? 1 : 0;
        }

        System.out.println(result);
    }
}
