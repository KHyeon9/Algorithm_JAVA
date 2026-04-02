import java.io.*;
import java.util.*;

public class BOJ15182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int[] oddOrEven = new int[2];
        int dataCnt = Integer.parseInt(br.readLine());
        int[][] dataArr = new int[dataCnt + 1][8];
        boolean[] isOddArr = new boolean[dataCnt + 1];
        for (int i = 0; i < dataCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int j = 0; j < 8; j++) {
                dataArr[i][j] = Integer.parseInt(st.nextToken());
                cnt += dataArr[i][j];
            }
            oddOrEven[cnt % 2]++;
            isOddArr[i] = cnt % 2 == 1;
        }
        // 홀수인지 짝수인지 저장
        boolean isOdd = oddOrEven[0] < oddOrEven[1];
        // 페리티 비트 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int parityCnt = 0;
        for (int i = 0; i < 8; i++) {
            dataArr[dataCnt][i] = Integer.parseInt(st.nextToken());
            parityCnt += dataArr[dataCnt][i];
        }
        isOddArr[dataCnt] = parityCnt % 2 == 1;
        br.close();

        // 바이트 부서진 곳 찾기
        int brokenByte = 0;
        for (int i = 0; i <= dataCnt; i++) {
            // 부서진 바이트면 저장 및 탈출
            if (isOddArr[i] != isOdd) {
                brokenByte = i + 1;
                break;
            }
        }
        // 비트 부서진 곳 찾기
        int brokenBit = 0;
        for (int i = 0; i < 8; i++) {
            int cnt = 0;
            for (int j = 0; j <= dataCnt; j++) {
                if (dataArr[j][i] == 1) {
                    cnt++;
                }
            }
            // 부서진 비트면 저장 및 탈출
            if ((cnt % 2 == 1) != isOdd) {
                brokenBit = i + 1;
                break;
            }
        }
        System.out.println(isOdd ? "Odd" : "Even");
        System.out.println(String.format("Byte %d is broken", brokenByte));
        System.out.println(String.format("Bit %d is broken", brokenBit));
    }
}
