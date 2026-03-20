import java.io.*;
import java.util.*;

public class BOJ4365 {
    static String[] pattern = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        // 기본 정렬 덱 생성
        String[] deck = new String[52];
        for (int i = 0; i < 52; i++) {
            deck[i] = value[i % 13] + " of " + pattern[i / 13];
        }
        // 셔플 갯수 만큼 셔플 저장
        int shuffleCnt = Integer.parseInt(br.readLine());
        int[][] shuffles = new int[shuffleCnt + 1][52];
        for (int i = 1; i <= shuffleCnt; i++) {
            int cnt = 0;
            while (cnt < 52) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    shuffles[i][cnt++] = Integer.parseInt(st.nextToken());
                }
            }
        }
        // 수행할 셔플 번호
        String line;
        while ((line = br.readLine()) != null) {
            int suffleNum = Integer.parseInt(line);
            deck = shuffleDeck(deck, shuffles[suffleNum]);

            StringBuilder sb = new StringBuilder();
            for (String card : deck) {
                sb.append(card).append("\n");
            }
            System.out.println(sb);
        }
    }
    // 덱 섞기
    private static String[] shuffleDeck(String[] deck, int[] shuffle) {
        String[] shuffledDeck = new String[52];

        for (int j = 0; j < 52; j++) {
            int i = shuffle[j];
            shuffledDeck[j] = deck[i - 1];
        }
        return shuffledDeck;
    }
}
