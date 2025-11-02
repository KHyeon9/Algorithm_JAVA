import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] mom = br.readLine().toCharArray();
        char[] dad = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());

        boolean[][] flag = new boolean[5][2];
        // 가능한 조합 계산 및 저장
        for (int i = 0; i < 5; i++) {
            char m1 = mom[2 * i];
            char m2 = mom[2 * i + 1];
            char d1 = dad[2 * i];
            char d2 = dad[2 * i + 1];
            // 열성인가 확인
            boolean canBeLower = false;
            boolean canBeUpper = false;
            // 가능한 조합
            char[] monGenes = {m1, m2};
            char[] dadGenes = {d1, d2};
            // 조합 확인하여 값 계산
            for (char mG : monGenes) {
                for (char dG : dadGenes) {
                    // 2개 모두 열성이어야 true
                    if (Character.isLowerCase(mG) && Character.isLowerCase(dG)) canBeLower = true;
                    // 2개중 하나만 우성이면 true
                    if (Character.isUpperCase(mG) || Character.isUpperCase(dG)) canBeUpper = true;
                }
            }
            // 저장
            flag[i][0] = canBeLower;
            flag[i][1] = canBeUpper;
        }
        // 입력마다 검사
        for (int i = 0; i < n; i++) {
            char[] bady = br.readLine().toCharArray();
            boolean possible = true;

            for (int j = 0; j < 5; j++) {
                // 열상이지만 flag에서 열성이 아닌 경우와 우선인데 flag에서 우성이 아닌경우
                if ((Character.isLowerCase(bady[j]) && !flag[j][0]) ||
                        (Character.isUpperCase(bady[j]) && !flag[j][1])) {
                    possible = false;
                    break;
                }
            }
            System.out.println(possible ? "Possible baby." : "Not their baby!");
        }
    }
}
