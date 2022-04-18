import java.util.ArrayList;
import java.util.Scanner;

public class _3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            int num = sc.nextInt() % 42;
            if (!list.contains(num)){
                list.add(num);
            }
        }

        System.out.println(list.size());
    }
}
