import java.io.*;
import java.util.*;

public class BOJ5648 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        ArrayList<Long> list = new ArrayList<>();
        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            String now = sc.next();
            // 받은 숫자를 거꾸로 만들어 long으로 변경
            StringBuilder sb = new StringBuilder(now);
            sb.reverse();
            list.add(Long.parseLong(sb.toString()));
        }
        list.sort(Comparator.naturalOrder());
        StringBuilder answer = new StringBuilder();
        for (long num : list) {
            answer.append(num).append("\n");
        }
        System.out.println(answer);
    }
}
