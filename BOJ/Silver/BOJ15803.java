import java.io.*;
import java.util.*;

public class BOJ15803 {
    static class StartPos {
        int x, y;

        public StartPos(String pos) {
            String[] split = pos.split(" ");
            this.x = Integer.parseInt(split[0]);
            this.y = Integer.parseInt(split[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StartPos star1 = new StartPos(br.readLine());
        StartPos star2 = new StartPos(br.readLine());
        StartPos star3 = new StartPos(br.readLine());

        int slope1 = (star1.y - star2.y) * (star2.x - star3.x);
        int slope2 = (star2.y - star3.y) * (star1.x - star2.x);

        System.out.println(slope1 == slope2 ? "WHERE IS MY CHICKEN?" : "WINNER WINNER CHICKEN DINNER!");

    }
}
