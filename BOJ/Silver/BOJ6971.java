import java.io.*;
import java.util.*;

public class BOJ6971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            List<int[]> list = new ArrayList<>();
            int num = Integer.parseInt(br.readLine());
            // 약수 집합 저장
            for (int n = 1; n <= num / 2; n++) {
                if (num % n == 0) {
                    int[] arr = {n, num / n};
                    list.add(arr);
                }
            }
            // 나쁜 정수인지 확인
            boolean isNasty =false;
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    int n1 = list.get(j)[0];
                    int n2 = list.get(j)[1];
                    int n3 = list.get(k)[0];
                    int n4 = list.get(k)[1];
                    // 하나의 약수 집합의 차가 다른 약수 집합의 합과 같은 경우
                    if (Math.abs(n1 - n2) == n3 + n4) {
                        isNasty = true;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(num)
                    .append(" is ")
                    .append(isNasty ? "nasty" : "not nasty");
            System.out.println(sb);
        }
        br.close();
    }
}
