import java.io.*;
import java.util.*;

public class BOJ1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        String[] list = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            String serial = br.readLine();
            list[i] = serial;
        }

        Arrays.sort(list, (o1, o2) -> {
            // 길이가 다른 경우 짧은거 앞으로
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            // 길이가 같으면 숫자인 경우 더해서 작은 합 앞으로
            int sum1 = sumElement(o1), sum2 = sumElement(o2);
            if (sum1 != sum2) {
                return sum1 - sum2;
            }
            // 두 경우 아니면 사전 순 정렬
            return o1.compareTo(o2);
        });
        StringBuilder sb = new StringBuilder();
        for (String serial : list) {
            sb.append(serial).append("\n");
        }
        System.out.println(sb);
    }

    private static int sumElement(String serial) {
        int sum = 0;
        for (char el : serial.toCharArray()) {
            if ('0' <= el && el <= '9') {
                sum += el - '0';
            }
        }
        return sum;
    }
}
