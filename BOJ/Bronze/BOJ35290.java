import java.io.*;

public class BOJ35290 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 2 || n == 6 || n == 7 || n == 8) {
            System.out.println("Think before submission");
        } else {
            System.out.println("Solve harder problems");
        }
    }
}
