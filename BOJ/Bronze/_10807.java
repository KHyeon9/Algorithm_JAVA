import java.util.Scanner;

public class _10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++){
            list[i] = sc.nextInt();
        }
        int v = sc.nextInt();
        int cnt = 0;

        for (int num : list) {
            if (num == v){
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}
