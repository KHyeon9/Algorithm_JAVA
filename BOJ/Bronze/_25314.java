import java.util.Scanner;

public class _25314 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = (int) Math.ceil(n / 4);
		
		for (int i = 0; i < t; i++) {
			System.out.print("long ");
		}
		System.out.println("int");
	}

}
