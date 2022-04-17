import java.util.Scanner;

public class _10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int[] time = new int[3];

        time[0] = s / 300;
        time[1] = s % 300 / 60;
        time[2] = s % 60 / 10;
        if (s % 10 > 0){
            System.out.println(-1);
        }
        else {
            for (int t : time){
                System.out.print(t + " ");
            }
            System.out.println();
        }

    }
}
