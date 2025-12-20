import java.util.Scanner;

public class BOJ2941 {
    static String[] croatiaAlpa = {
            "c=", "c-", "dz=", "d-", "lj",
            "nj", "s=", "z="
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int strLen = str.length();
        int answer = 0;

        for (int i = 0; i < strLen; i++) {
            boolean isCroatia = false;
            for (String el : croatiaAlpa) {
                int len = el.length();
                if (i + len - 1 < strLen) {
                    String temp = str.substring(i, i + len);
                    // 알파벳에 포함되는가 확인
                    if (el.equals(temp)) {
                        isCroatia = true;
                        break;
                    }                }
            }
            // 저장된 알파벳에 포함되지 않으면 +1
            answer += !isCroatia ? 1 : 0;
        }

        System.out.println(answer);
    }
}
