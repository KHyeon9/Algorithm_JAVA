import java.util.Scanner;

public class BOJ5622 {
    static String[] wordPosition = {
            "ABC", "DEF", "GHI", "JKL", "MNO",
            "PQRS", "TUV", "WXYZ"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int answer = 0;

        for (String s : str.split("")) {
            for (int i = 0; i < 8; i++) {
                // 저장된 문자열에 포함되면
                if (wordPosition[i].contains(s)) {
                    // 문자열의 위치 +3 만큼 더해준다
                    answer += i + 3;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
