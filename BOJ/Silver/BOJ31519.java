import java.io.*;
import java.util.*;

public class BOJ31519 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int musicCnt = Integer.parseInt(st.nextToken());
        int addNote = Integer.parseInt(st.nextToken());

        int[] musicNotes = new int[musicCnt];
        for (int i = 0; i < musicCnt; i++) {
            musicNotes[i] = Integer.parseInt(br.readLine());
        }
        // 검사를 편하게 하기 위한 정렬
        Arrays.sort(musicNotes);
        // 녹음 횟수 구하기
        int curIdx = 0, answer = 0;
        // 한계 음보다 작은 경우 한번에 녹음
        while (curIdx < musicCnt) {
            answer++;
            //  현재 한계음 구하기
            int maxNote = musicNotes[curIdx] + addNote;
            // 한계음보다 작으면 녹음하므로 인덱스 넘기기
            while (curIdx < musicCnt && musicNotes[curIdx] <= maxNote) {
                curIdx++;
            }
        }
        System.out.println(answer);
    }
}
