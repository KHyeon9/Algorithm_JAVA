import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // 컵이 3개이므로 처음 공이 있는 경우의 수 3개 선언 
        int[][] cupsList = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        // 가장 많이 맞춘 갯수를 구하기 위한 cnt 리스트 선언
        int[] resCnts = {0, 0, 0};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            // 3개의 경우의 수를 돌아가며 스왑 후 cnt를 조건에 맞으면 증가
            for (int j = 0; j < 3; j++) {
                cupsList[j] = swap(cupsList[j], a, b);
                if (cupsList[j][g] == 1) resCnts[j]++;
            }
        }
        System.out.println(Arrays.stream(resCnts).max().getAsInt());
    }
    // 스왑한 리스트 반환
    public static int[] swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
}
