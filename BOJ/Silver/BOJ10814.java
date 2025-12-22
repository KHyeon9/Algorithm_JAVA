import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[][] members = new String[n][2];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 2; j++) {
                members[i][j] = sc.next();
            }
        }
        // Arrays.sort(members, (o1, o2) -> {
        //     return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
        // });
        // 그 추출된 키를 바탕으로 정수 비교를 수행하는 Comparator 객체 사용
        Arrays.sort(members,
                Comparator.comparingInt(o -> Integer.parseInt(o[0])));

        for (String[] member : members) {
            System.out.println(member[0] + " " + member[1]);
        }
    }
}
