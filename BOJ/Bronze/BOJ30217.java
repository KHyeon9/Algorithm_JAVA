import java.util.Scanner;

public class BOJ30217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split("");
        String[] s2 = sc.nextLine().split("");
        String vowel = "aeiou";

        StringBuilder firstWord = new StringBuilder();
        StringBuilder secondWord = new StringBuilder();
        String v1 = "";
        String v2 = "";

        // 첫 번째 단어 처리
        firstWord.append(s1[0]);
        for (int i = 1; i < s1.length; i++) {
            if (vowel.contains(s1[i])) {
                v1 = s1[i];
                break;
            }
            firstWord.append(s1[i]);
        }
        // 두 번째 단어 처리
        secondWord.append(s2[s2.length - 1]);
        for (int i = s2.length - 2; i >= 0; i--) {
            if (vowel.contains(s2[i])) {
                v2 = s2[i];
                break;
            }
            secondWord.append(s2[i]);
        }
        secondWord.reverse();
        // 결함
        StringBuilder answer = new StringBuilder();
        answer.append(firstWord);

        if (!v2.isEmpty()) {
            answer.append(v2);
        } else if (!v1.isEmpty()) {
            answer.append(v1);
        } else {
            answer.append("o");
        }

        answer.append(secondWord);
        System.out.println(answer);
    }
}
