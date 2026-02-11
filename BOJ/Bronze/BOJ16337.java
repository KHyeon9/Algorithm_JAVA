import java.io.*;

public class BOJ16337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dice = new String[3];
        for (int i = 0; i < 3; i++) {
            dice[i] = br.readLine();
        }
        System.out.println(checkDice(dice) == -1 ? "unknown" : checkDice(dice));
    }

    private static int checkDice(String[] dice) {
        String[][] diceShapes = {
                {":::", ":o:", ":::"}, // 1
                {"::o", ":::", "o::"}, // 2 (A)
                {"o::", ":::", "::o"}, // 2 (B - 반전)
                {"::o", ":o:", "o::"}, // 3 (A)
                {"o::", ":o:", "::o"}, // 3 (B - 반전)
                {"o:o", ":::", "o:o"}, // 4
                {"o:o", ":o:", "o:o"}, // 5
                {"o:o", "o:o", "o:o"}, // 6 (가로)
                {"ooo", ":::", "ooo"}  // 6 (만약 세로가 있다면 추가)
        };

        int[] diceNum = {1, 2, 2, 3, 3, 4, 5, 6, 6};

        for (int i = 0; i < 9; i++) {
            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                if (!dice[j].equals(diceShapes[i][j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return diceNum[i];
            }
        }
        return -1;
    }
}
