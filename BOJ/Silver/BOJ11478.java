import java.util.HashSet;
import java.util.Scanner;

public class BOJ11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        
        int strLen = str.length();

        HashSet<String> stringParts = new HashSet<>();
        for (int i = 1; i < strLen + 1; i++) {
            for (int j = 0; j < strLen; j++) {
                // 범위 벗어나면 탈출
                if (j + i >= strLen + 1) {
                    break;
                }
                String part = str.substring(j, j + i);
                stringParts.add(part);
            }
        }

        System.out.println(stringParts.size());
        sc.close();
    }
}
