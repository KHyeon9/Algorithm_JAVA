import java.io.*;
import java.util.*;

public class BOJ34413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        // 숫자가 아닌것 공백으로
        String line = br.readLine().replaceAll("[d+]", " ");

        StringTokenizer st = new StringTokenizer(line);
        double X = Double.parseDouble(st.nextToken());
        double Y = Double.parseDouble(st.nextToken());
        double Z = Double.parseDouble(st.nextToken());
        // 평균 계산
        double result = (X * (1 + Y)) / 2 + Z;
        // 소수점 확인하여 출력
        if (result == (int) result) {
            System.out.println((int) result);
        } else {
            System.out.println(result);
        }
    }
}
