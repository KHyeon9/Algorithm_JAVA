import java.util.*;

public class BOJ1181 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> strArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            // 중복시 입력 x
            if (!strArr.contains(str)){
                strArr.add(str);
            }
        }
        // 길이 오름차순 정렬 길이가 같으면 사전순(compareTo) 정렬
        strArr.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        // 출력
        StringBuilder answer = new StringBuilder();
        for (String str : strArr) {
            answer.append(str).append("\n");
        }
        System.out.println(answer);
    }
}
