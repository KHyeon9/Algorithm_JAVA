import java.util.Scanner;

public class _4999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        if (s1.length() < s2.length()){
            System.out.println("no");
        } else {
            System.out.println("go");
        }
    }
}
