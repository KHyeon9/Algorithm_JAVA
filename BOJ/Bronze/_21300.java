import java.util.Scanner;

public class _21300 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        for(int i = 0; i < 6; i++){
            sum += scanner.nextInt() * 5;
        }

        System.out.println(sum);
    }
}
