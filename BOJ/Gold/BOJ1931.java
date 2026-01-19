import java.io.*;
import java.util.*;

public class BOJ1931 {
    static class MeetingTime {
        int start, end;

        public MeetingTime (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        MeetingTime[] meetings = new MeetingTime[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new MeetingTime(start, end);
        }
        // 끝나는 시간 기준 오름 차순 정렬
        // 같으면 시작 시간이 빠른 순으로 정렬
        Arrays.sort(meetings, (a, b) ->
                {
                    if (a.end == b.end) {
                        return a.start - b.start;
                    }
                    return a.end - b.end;
                });

        int answer = 0, nowTime = 0;
        for (int i = 0; i < n; i++) {
            // 현재 시간보다 미팅 시같이 같거나크면 가능
            if (nowTime <= meetings[i].start) {
                // 그 끝나는 시간으로 현재 시간 변경
                nowTime = meetings[i].end;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
