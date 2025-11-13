import java.util.Scanner;

public class BOJ1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        // -를 통해 배열을 만들어 +끼리만 뭉쳐있도록 만듦
        String[] str = line.split("-");
        int answer = 0;

        for (int i = 0; i < str.length; i++) {
            // 첫번째 숫자인 경우만 더해주고 나머지는 빼줌
            answer += i != 0 ? -sumNum(str[i]) : sumNum(str[i]);
        }

        System.out.println(answer);
    }
    // +끼리 뭉치거나 값이 1개인 것들을 모두 sumNum에 더함
    public static int sumNum(String line) {
        int sumNum = 0;
        String[] str = line.split("\\+");
        for (String el : str) {
            sumNum += Integer.parseInt(el);
        }
        return sumNum;
    }
}
