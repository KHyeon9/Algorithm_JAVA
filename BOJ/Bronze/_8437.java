import java.math.BigInteger;
import java.util.Scanner;

public class _8437 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BigInteger totalApple = sc.nextBigInteger();
		BigInteger gap = sc.nextBigInteger();
		BigInteger two = new BigInteger("2");
		
		BigInteger avg = totalApple.subtract(gap).divide(two);
		System.out.println(avg.add(gap));
		System.out.println(avg);
 	}	
}
