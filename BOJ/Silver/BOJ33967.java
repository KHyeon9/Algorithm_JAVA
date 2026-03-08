import java.util.*;

public class BOJ33967 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        String train = sc.next();
        // 총 방의 갯수 구하기
        int answer = 0;
        for (int i = 0; i < len - 1; i++) {
            String now = train.substring(i, i + 2);
            answer += getRoomCnt(now);
        }
        System.out.println(answer);
        sc.close();
    }
    // 모양에 따른 방의 갯수 구하기
    private static int getRoomCnt(String now) {
        if (now.equals("][")) return 0;
        if (now.equals("55") || now.equals("22")) return 2;
        return 1;
    }
}
