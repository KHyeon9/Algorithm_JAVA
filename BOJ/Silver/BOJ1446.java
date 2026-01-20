import java.io.*;
import java.util.*;

public class BOJ1446 {
    static class Shortcut {
        int next, dist;

        public Shortcut (int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int targetDist = Integer.parseInt(st.nextToken());

        Map<Integer, ArrayList<Shortcut>> shortcutMap = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            // 지름길 집어넣기
            ArrayList<Shortcut> shortcuts = shortcutMap
                    .getOrDefault(start, new ArrayList<>());
            shortcuts.add(new Shortcut(next, dist));
            shortcutMap.put(start, shortcuts);
        }

        int[] highWay = new int[targetDist + 1];
        Arrays.fill(highWay, Integer.MAX_VALUE);
        // 시작값 셋팅
        highWay[0] = 0;
        for (int i = 0; i <= targetDist; i++) {
            if (i > 0) {
                // 지름길을 안타고 이동한 경우 계산
                highWay[i] = Math.min(highWay[i], highWay[i - 1] + 1);
            }
            // 지름길이 존재하는 경우
            if (shortcutMap.containsKey(i)) {
                ArrayList<Shortcut> shortcuts = shortcutMap.get(i);
                for (Shortcut shortcut : shortcuts) {
                    // 목적지를 안넘어가는 경우 검사
                    if (shortcut.next <= targetDist) {
                        // 다음 위치의 최소값 계산
                        highWay[shortcut.next] = Math.min(
                                highWay[shortcut.next], highWay[i] + shortcut.dist);    
                    }
                }
            }

        }
        System.out.println(highWay[targetDist]);
    }
}
