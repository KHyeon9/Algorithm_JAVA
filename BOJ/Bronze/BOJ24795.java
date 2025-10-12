import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ24795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Y = sc.nextInt();
        // 장애물 중복 제거를 위한 set
        Set<Integer> found = new HashSet<>();;
        // 넘어야할 장애물
        for (int i = 0; i < Y; i++) {
            found.add(sc.nextInt());
        }
        // 출력
        for (int i = 0; i < N; i++) {
            if (!found.contains(i)) {
                System.out.println(i);
            }
        }
        System.out.println("Mario got " + found.size() + " of the dangerous obstacles.");
    }
}
