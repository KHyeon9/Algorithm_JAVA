import java.util.Scanner;

public class _14928 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();

        int result = 0;
        for (int i=0; i<n.length(); i++){
            result = (result * 10 + (n.charAt(i) - '0')) % 20000303;
        }
        System.out.println(result);

    }
}
