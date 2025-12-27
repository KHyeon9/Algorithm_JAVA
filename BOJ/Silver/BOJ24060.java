import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24060 {
    static int cnt = 0;
    static int m;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(nums, 0, n - 1);
        // answer가 셋팅 안되면 -1 출력
        System.out.println(answer);
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        // 왼쪽 나누기
        mergeSort(nums, left, middle);
        // 오른쪽 나누기
        mergeSort(nums, middle + 1, right);
        // 병합
        merge(nums, left, middle, right);
    }

    private static void merge(int[] nums, int left, int middle, int right) {
        // 병합전 담을 배열 선언
        int[] temp = new int[right - left + 1];
        // 인쪽, 오른쪽 포인터 및 temp를 가르킬 idx 선언
        int start = left, end = middle + 1, idx = 0;
        // 정렬 시작
        while (start <= middle && end <= right) {
            if (nums[start] <= nums[end]) {
                temp[idx++] = nums[start++];
            } else {
                temp[idx++] = nums[end++];
            }
        }
        // 왼쪽 남은거 저장
        while (start <= middle) temp[idx++] = nums[start++];
        // 오른쪽 남은거 저장
        while (end <= right) temp[idx++] = nums[end++];
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
            cnt++;
            // m번 숫자가 바뀔때 answer 저장
            if (cnt == m) {
                answer = temp[i];
            }
        }
    }
}
