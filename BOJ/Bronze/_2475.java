import java.util.Scanner;

public class _2475 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int[] koiNum = new int[5];
		int total = 0;
		
		for (int i = 0; i < koiNum.length; i++) {
			koiNum[i] = sc.nextInt();
		}
		
		for (int num : koiNum) {
			total += Math.pow(num, 2);
		}
		
		System.out.println(total % 10);
	}	
}
