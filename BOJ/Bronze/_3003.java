import java.util.Scanner;

public class _3003 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] chess = {1, 1, 2, 2, 2, 8};
		int[] myChess = new int[6];
		int n;
		
		for (int i = 0; i < chess.length; i++) {
			myChess[i] = sc.nextInt();
		}
		
		for (int i = 0; i < chess.length; i++) {
			n = chess[i] - myChess[i];
			System.out.print(n + " ");
		}
		
 	}	
}
