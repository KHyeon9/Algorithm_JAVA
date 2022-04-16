import java.util.Scanner;

public class _5543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bugerMin = 3000;
        int drinkMin = 3000;

        for (int i = 0; i < 3; i ++){
            int buger = sc.nextInt();
            if (bugerMin > buger){
                bugerMin = buger;
            }
        }

        for (int i = 0; i < 2; i ++){
            int drink = sc.nextInt();
            if (drinkMin > drink){
                drinkMin = drink;
            }

        }

        System.out.println(bugerMin + drinkMin - 50);
    }
}
