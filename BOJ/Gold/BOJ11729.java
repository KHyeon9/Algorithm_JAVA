import java.util.Scanner;

public class BOJ11729 {
    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int diskCnt = sc.nextInt();

        hanoi(diskCnt, 1, 3, 2);
        // 옮긴 횟수 계산
        System.out.println((int) Math.pow(2, diskCnt) - 1);
        System.out.println(answer);
    }
    /** 하노이 탑 옮기기 로직
     * @param diskCnt 현재 존재하는 원판
     * @param start   시작점
     * @param end     목적지
     * @param other   경유지
     */
    private static void hanoi(
            int diskCnt, int start, int end, int other
    ) {
        // 위에 원판이 없어 옮기면 되는 경우
        if (diskCnt == 1) {
            answer.append(start + " " + end).append("\n");
            return;
        }
        // 현재 옮겨야 하는 원판 위에 (diskCnt - 1)개의 원판
        // 시작점과 목적지가 아닌 위치로 옮기기
        hanoi(diskCnt - 1, start, other, end);
        // 위에 원판을 경유지에 옮겨서 현재 원판 옮김
        answer.append(start + " " + end).append("\n");
        // 경유지에 있는 원판들 목적지로 옮기기
        hanoi(diskCnt - 1, other, end, start);
    }
}
