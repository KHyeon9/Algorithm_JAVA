import java.util.Scanner;

public class BOJ34691 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String line = sc.next();
            // 탈출 조건
            if (line.equals("end")) break;
            // 출력
            System.out.println(solution(line));
        }
        sc.close();
    }

    static String solution(String str) {
        if (str.equals("animal")) return "Panthera tigris";
        if (str.equals("flower")) return "Forsythia koreana";
        return "Pinus densiflora";
    }
}
