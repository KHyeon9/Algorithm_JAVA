public class LeetCode1323 {
    // Maximum 69 Number
    public int maximum69Number (int num) {
        String[] numStr = String.valueOf(num).split("");

        for (int i = 0; i < numStr.length; i++) {
            if (numStr[i].equals("6")) {
                numStr[i] = "9";
                break;
            }
        }
        return  Integer.parseInt(String.join("", numStr));
    }
}

