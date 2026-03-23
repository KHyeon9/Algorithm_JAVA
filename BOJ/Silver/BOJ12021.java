import java.io.*;
import java.util.*;

public class BOJ12021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        // 산술 평균과 기하 평균의 문제로 n이 커질수록
        // 결국 두개의 수가 같아지므로 두개의 곱의 루트가 답
        System.out.println(String.format("%.6f %.6f", Math.sqrt(x * y), Math.sqrt(x * y)));
    }
}
