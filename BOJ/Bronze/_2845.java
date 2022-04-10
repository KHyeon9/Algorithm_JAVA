import java.util.Scanner;

public class _2845 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int p = sc.nextInt();
		int[] arr = new int[5];
		int[] result = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i] - (l * p);
		}

		for(int i : result) {
			System.out.print(i + " ");
		}
 	}	
}
