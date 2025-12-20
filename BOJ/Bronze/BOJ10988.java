import java.util.Scanner;

public class BOJ10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int len = str.length();
        boolean flag = true;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                flag = false;
            }
        }

        System.out.println(flag ? 1 : 0);
    }
}
