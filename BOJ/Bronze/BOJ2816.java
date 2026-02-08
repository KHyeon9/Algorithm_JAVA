import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        String[] channel = new String[cnt];
        int kbsPointer = 0;
        for (int i = 0; i < cnt; i++) {
            channel[i] = br.readLine();
            if (channel[i].equals("KBS1")) {
                kbsPointer = i;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        // kbs1의 위치를 바꾼 버튼 순서 계산
        answer.append(returnButton(channel, 0, kbsPointer));
        // 변경된 kbs2의 위치 찾기
        for (int i = 0; i < cnt; i++) {
            if (channel[i].equals("KBS2")) {
                kbsPointer = i;
            }
        }
        // kbs2의 위치를 바꾼 버튼 순서 계산
        answer.append(returnButton(channel, 1, kbsPointer));

        System.out.println(answer);
    }
    // 버튼 순서 계산
    private static StringBuilder returnButton(String[] channel, int target, int position) {
        StringBuilder answer = new StringBuilder();
        // 해당 채널 위치까지 내려감
        for (int j = 0; j < position; j++) {
            answer.append(1);
        }
        int pointer = position;
        while (pointer > target) {
            // 해당 채널이 target위치에 도달할 대까지 swap 및 위로 올리기 버튼 누르기
            answer.append(4);
            String temp = channel[pointer];
            channel[pointer] = channel[pointer - 1];
            channel[pointer - 1] = temp;
            pointer--;
        }
        return answer;
    }
}
