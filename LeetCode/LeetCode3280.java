public class LeetCode3280 {
    // Convert Date to Binary
    public String convertDateToBinary(String date) {
        // '-' 기준 분리
        String[] dataSplit = date.split("-");
        String[] ans = new String[dataSplit.length];
        // 이진법으로 변경
        for (int i = 0; i < dataSplit.length; i++) {
            int convInt = Integer.parseInt(dataSplit[i]);
            ans[i] = Integer.toBinaryString(convInt);
        }
        return String.join("-", ans);
    }
}

