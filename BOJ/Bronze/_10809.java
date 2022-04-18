import java.util.Scanner;

public class _10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }

        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';
            if (arr[n] == -1) {
                arr[n] = i;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
