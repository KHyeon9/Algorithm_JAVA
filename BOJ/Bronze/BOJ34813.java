import java.util.Scanner;

public class BOJ34813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String subNum = sc.next();
        char first = subNum.charAt(0);

        System.out.println(getSubName(first));
    }
    // 과목 이름 반환
    private static String getSubName(char firstChar) {
        switch (firstChar) {
            case 'F': return "Foundation";
            case 'C': return "Claves";
            case 'V': return "Veritas";
            default: return "Exploration";
        }
    }
}
