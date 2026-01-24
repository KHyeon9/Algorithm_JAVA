import java.io.*;
import java.util.*;

public class BOJ13913 {
    static class Info {
        int pos, time;

        public Info(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
    static Integer[] parents = new Integer[100001];
    static {
        Arrays.fill(parents, null);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subinPos = Integer.parseInt(st.nextToken());
        int sisterPos = Integer.parseInt(st.nextToken());
        // 탐색 로직
        Info answer = getInfo(new Info(subinPos, 0), sisterPos);
        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(answer.time).append("\n");
        // 역추적
        ArrayList<Integer> posList = new ArrayList<>();
        int pos = sisterPos;
        while (pos != -1) {
            posList.add(pos);
            pos = parents[pos];
        }
        // 역추적
        Collections.reverse(posList); // 11 버전이므로 변경
        for (int p : posList) {
            sb.append(p).append(" ");
        }
        System.out.println(sb);
        
    }

    private static Info getInfo(Info subin, int target) {
        // visited 셋팅
        parents[subin.pos] = -1;
        // 덱 셋팅
        Deque<Info> infoDeq = new ArrayDeque<>();
        infoDeq.addLast(subin);
        // 탐색
        while (!infoDeq.isEmpty()) {
            Info now = infoDeq.pollFirst();

            if (now.pos == target) {
                return now;
            }
            // 이동 위치 배열
            int[] movePos = {now.pos - 1, now.pos + 1, now.pos * 2};
            for (int next : movePos) {
                // 움직일 수 있고 방문하지 않은 경우
                if (isMove(next) && parents[next] == null) {
                    // 해당 위치에 부모 위치를 넣어서 추적 가능하도록함
                    parents[next] = now.pos;
                    infoDeq.addLast(new Info(next, now.time + 1));
                }
            }
        }
        return null;
    }

    private static boolean isMove(int next) {
        return (next >= 0 && next < 100001);
    }
}
