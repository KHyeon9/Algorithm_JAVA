import java.util.Arrays;
import java.util.Scanner;

public class BOJ4779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int size = (int) Math.pow(3, n);
            // 칸토어 배열 초기화
            char[] cantor = new char[size];
            Arrays.fill(cantor, '-');
            // 로직 시작
            cantorSet(cantor, 0, size);
            // 출력
            StringBuilder answer = new StringBuilder();
            for (char el : cantor) answer.append(el);
            System.out.println(answer);
        }
    }

    private static void cantorSet(char[] set, int start, int size) {
        if (size == 0) return;
        int newSize = size / 3;
        // 왼쪽 부분 계산
        cantorSet(set, start, newSize);
        // 가운대 파내기
        for (int i = start + newSize; i < start + newSize * 2; i++)
            set[i] = ' ';
        // 오른쪽 계산
        cantorSet(set, start + newSize * 2, newSize);
    }
}
