import java.io.*;

public class BOJ6693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();

            if (input.equals("END")) {
                break;
            }

            String[] moveList = input.replace(".", "").split(",");
            double[] pos = getPos(moveList);
            double dist = Math.sqrt(pos[0] * pos[0] + pos[1] * pos[1]);
            System.out.println(
                    String.format(
                            "You can go to (%.3f,%.3f), the distance is %.3f steps.",
                            pos[0],
                            pos[1],
                            dist
                    )
            );
        }
        br.close();
    }

    private static double[] getPos(String[] moveList) {
        double[] answer = {0, 0};
        double cross = Math.sqrt(2);
        for (String move : moveList) {
            // 숫자 끝나는 위치 구하기
            int numIdx = 0;
            while (numIdx < move.length() && (Character.isDigit(move.charAt(numIdx)))) {
                numIdx++;
            }
            // 거리와 방향 셋팅
            double dist = Double.parseDouble(move.substring(0, numIdx));
            String dir = move.substring(numIdx);
            // 방향에 따른 위치 변경
            if (dir.equals("N")) {
                answer[1] += dist;
            } else if (dir.equals("NE")) {
                answer[1] += dist / cross;
                answer[0] += dist / cross;
            } else if (dir.equals("E")) {
                answer[0] += dist;
            } else if (dir.equals("SE")) {
                answer[0] += dist / cross;
                answer[1] -= dist / cross;
            } else if (dir.equals("S")) {
                answer[1] -= dist;
            } else if (dir.equals("SW")) {
                answer[0] -= dist / cross;
                answer[1] -= dist / cross;
            } else if (dir.equals("W")) {
                answer[0] -= dist;
            } else if (dir.equals("NW")) {
                answer[1] += dist / cross;
                answer[0] -= dist / cross;
            }
        }
        return answer;
    }
}
