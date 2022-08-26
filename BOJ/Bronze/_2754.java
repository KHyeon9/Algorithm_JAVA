package beakjoon;

import java.util.Scanner;

public class _2754 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String grade = sc.next();
		float res = 0;
		char first = grade.charAt(0);
		
		if (first == 'A') {
			res = 4;
		} else if (first == 'B') {
			res = 3;
		} else if (first == 'C') {
			res = 2;
		} else if (first == 'D') {
			res = 1;
		} else {
			System.out.println(res);
			return;
			
		}
		
		char second = grade.charAt(1);
		
		if (second == '+') {
			res += 0.3;
		} else if (second == '-') {
            res -= 0.3;
        }
		
		System.out.println(res);
	}
}
