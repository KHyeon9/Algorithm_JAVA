import java.io.*;
import java.util.*;

public class BOJ7599 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int fontWith = Integer.parseInt(st.nextToken());
            // 탈출
            if (name.equals("#") && fontWith == 0) {
                break;
            }
            // 도서관 명 출력
            System.out.println(name + " " + "Library");
            // 책 갯수 받고 갯수 만큼 계산 및 출력
            int cnt = Integer.parseInt(br.readLine());
            for (int num = 1; num <= cnt; num++) {
                st = new StringTokenizer(br.readLine());
                double bookWith = Double.parseDouble(st.nextToken());
                String text = st.nextToken();
                int textWith = (text.length() * fontWith) + 2;

                if (bookWith < textWith) {
                    System.out.println(String.format("Book %d vertical", num));
                } else {
                    System.out.println(String.format("Book %d horizontal", num));
                }
            }
        }
    }
}
