import java.io.*;
import java.util.*;

public class BOJ35368 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int exit = Integer.parseInt(st.nextToken());
        int boxCnt = Integer.parseInt(st.nextToken());

        int[] boxPos = new int[size + 1];
        for (int i = 0; i < boxCnt; i++) {
            int pos = Integer.parseInt(br.readLine());
            boxPos[pos]++;
        }
        // 시계 방향 박스 수 체크
        int forwordCnt = 0;
        for (int i = 1; i < exit; i++) {
            forwordCnt += boxPos[i];
        }
        // 반시계 방향 박스 수 체크
        int reverseCnt = 0;
        for (int i = exit; i <= size; i++) {
            reverseCnt += boxPos[i];
        }
        System.out.println(Math.min(forwordCnt, reverseCnt));
    }
}
