import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            List<Character> alpa = new ArrayList<>();
            boolean flag = true;

            for (char ch : str.toCharArray()) {
                // 리스트에 해당 문자가 없는 경우 추가
                if (!alpa.contains(ch)) {
                    alpa.add(ch);
                    continue;
                }
                // 리스트에 해당 문자가 존재하는데 
                // 맨 마지막 값과 다르면 flag 반전
                if (alpa.get(alpa.size() - 1) != ch) {
                    flag = false;
                    break;
                }
            }
            answer += flag ? 1 : 0;
        }
        System.out.println(answer);
    }
}
