import java.util.*;
import java.io.*;

public class BOJ3018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        // 결과 저장할 배열 선언
        List<ArrayList<Integer>> answer = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            answer.add(new ArrayList<>());
        }
        // 노래 저장할 Set과 현재 노래 변수 선언
        Set<Integer> totalSongs = new HashSet<>();
        int nowSong = 0;

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            // 파티 참가한 인원 저장
            Set<Integer> join = new HashSet<>();
            for (int j = 0; j < k; j++) {
                join.add(Integer.parseInt(st.nextToken()));
            }
            // 선영이 있는지 확인
            if (join.contains(1)) {
                // 있으면 새로운 노래 만들기
                nowSong++;
                // 전체 노래에 추가
                totalSongs.add(nowSong);
                // 참여한 인원들의 노래 리스트에 추가
                for (int person : join) {
                    answer.get(person).add(nowSong);
                }
            } else {
                // 서로 아는 노래를 주고 받아 동기화를 위한 set
                Set<Integer> temp = new HashSet<Integer>();
                for (int person : join) {
                    ArrayList<Integer> songs = answer.get(person);
                    temp.addAll(songs);
                }
                // 동기화
                for (int person : join) {
                    ArrayList<Integer> change = new ArrayList<>(temp);
                    answer.set(person, change);
                }
            }
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (nowSong == answer.get(i).size()) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
