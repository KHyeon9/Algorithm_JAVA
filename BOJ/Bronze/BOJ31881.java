import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ31881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] computers = new int[n + 1];
        int infectionComputers = 0;

        for (int i = 0; i < q; i++) {
            String[] line = br.readLine().split(" ");
            // 길이가 2인 경우 감염 혹은 치료
            if (line.length == 2) {
                int idx = Integer.parseInt(line[1]);
                // 0번 값이 1이면 감염 아니면 치료
                if (line[0].equals("1")) {
                    if (computers[idx] == 0) infectionComputers++;
                    computers[idx] = 1;
                } else {
                    if (computers[idx] == 1) infectionComputers--;
                    computers[idx] = 0;
                }
            } else {
                // 길이가 1인 경우는 3 밖이 없어서 출력
                System.out.println(n - infectionComputers);
            }
        }
    }
}
