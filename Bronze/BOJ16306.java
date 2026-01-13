import java.util.*;
import java.io.*;

public class BOJ16306 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());

        List<Integer> divList = new ArrayList<>();
        for (int n = 1; n <= Math.sqrt(v) + 1; n++) {
            if (v % n == 0) divList.add(n);
        }
        // 정답 구하기
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < divList.size(); i++) {
            int valFirst = divList.get(i);
            for (int j = i; j < divList.size(); j++) {
                int valSecond = divList.get(j);
                if (v % (valFirst * valSecond) == 0) {
                    int valThird = v / (valFirst * valSecond);
                    // 각 마주보는 변을 구하고 * 2
                    int result = 2 * (valFirst * valSecond + valFirst * valThird + valSecond * valThird);
                    answer = Math.min(answer, result);
                }
            }
        }
        System.out.println(answer);
    }
}
