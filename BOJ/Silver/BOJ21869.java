import java.io.*;
import java.util.*;

public class BOJ21869 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        if (size == 1) {
            // 1일때는 1개만 존재
            System.out.println(1);
            System.out.println(1 + " " + 1);
        } else {
            // 1이 아닌 경우 2n - 2개 존재
            StringBuilder answer = new StringBuilder();
            // 첫번째 줄을 다 채웠을때 넣을수 있는 갯수는
            // 마지막 줄 양끝을 제외하고 넣을 수 있음
            answer.append(size * 2 - 2).append("\n");
            for (int i = 1; i <= size; i++) {
                answer.append(1 + " " + i).append("\n");
            }
            for (int i = 2; i < size; i++) {
                answer.append(size + " " + i).append("\n");
            }
            System.out.println(answer);

        }
    }
}
