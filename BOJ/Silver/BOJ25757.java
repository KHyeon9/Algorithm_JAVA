import java.io.*;
import java.util.*;

public class BOJ25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int joinCnt = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        Set<String> players = new HashSet<>();
        for (int i = 0; i < joinCnt; i++) {
            players.add(br.readLine());
        }

        int playerCnt = players.size();
        if (game == 'Y') {
            System.out.println(playerCnt);
        } else if (game == 'F') {
            System.out.println(playerCnt / 2);
        } else {
            System.out.println(playerCnt / 3);
        }
    }
}
