import java.io.*;
import java.util.*;

public class BOJ7466 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();
        // 가로 길이와 세로길이 구하기
        int width = 0; // 남북 방향 각 사이 거리므로 가로 길이
        for (int i = 0; i < n - 1; i++) {
            width += sc.nextInt();
        }
        int height = 0; // 동서 방향 각 사이 거리므로 세로 길이
        for (int i = 0; i < e - 1; i++) {
            height += sc.nextInt();
        }
        // 피타고라스 정리로 대각선을 구해 올림 처리
        System.out.println((int) Math.ceil(Math.sqrt(width * width + height * height)));
    }
}
