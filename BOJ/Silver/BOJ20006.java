import java.io.*;
import java.util.*;

public class BOJ20006 {
    static class Room {
        int playerCnt = 0;
        int roomLimit;
        int limitStart, limitEnd;
        boolean isFull = false;
        List<Player> joinPlayers = new ArrayList<>();

        public Room (int playerCnt, int roomLimit, int limitStart, int limitEnd) {
            this.playerCnt = playerCnt;
            this.roomLimit = roomLimit;
            this.limitStart = limitStart;
            this.limitEnd = limitEnd;
        }
        // 잠여 가능한지 확인
        public boolean isJoin(Player player) {
            int playerLevel = player.level;
            if (isFull) {
                return false;
            }
            return limitStart <= playerLevel && limitEnd >= playerLevel;
        }
        // 유저 입장
        public void addPlayer(Player player) {
            this.playerCnt++;
            this.joinPlayers.add(player);

            if (this.roomLimit == this.playerCnt) {
                this.isFull = true;
            }
        }
        // 참여 플레이어 정렬 리스트 반환
        public List<Player> sortJoinPlayers() {
           Collections.sort(joinPlayers, (o1, o2) -> {
                return o1.name.compareTo(o2.name);
            });
           return joinPlayers;
        }
    }

    static class Player {
        int level;
        String name;
        
        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
        // 유저 출력
        public String toString() {
            return level + " " + name;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int playerCnt = Integer.parseInt(st.nextToken());
        int roomLimit = Integer.parseInt(st.nextToken());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < playerCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int playerLevel = Integer.parseInt(st.nextToken());
            String playerName = st.nextToken();
            Player player = new Player(playerLevel, playerName);
            // 잠여 가능한지 확인
            boolean isJoin = false;
            for (Room room : rooms) {
                if (room.isJoin(player)) {
                    // 잠여 가능하면 유저 추가
                    room.addPlayer(player);
                    isJoin = true;
                    break;
                }
            }
            // 참여할 방이 없으면 방 만들기
            if (!isJoin) {
                Room room = new Room(0, roomLimit, playerLevel - 10, playerLevel + 10);
                room.addPlayer(player);
                rooms.add(room);
            }
        }
        br.close();
        // 출력
        StringBuilder answer = new StringBuilder();
        for (Room room : rooms) {
            if (!room.isFull) {
                answer.append("Waiting!").append("\n");
            } else {
                answer.append("Started!").append("\n");
            }
            for (Player player : room.sortJoinPlayers()) {
                answer.append(player.toString()).append("\n");
            }
        }
        System.out.println(answer);
    }
}
