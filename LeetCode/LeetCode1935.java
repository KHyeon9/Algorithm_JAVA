public class LeetCode1935 {
    // Maximum Number of Words You Can Type
    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;

        for (String s : text.split(" ")) {
            int flag = 1;

            if (!brokenLetters.isEmpty()) {
                for (String br : brokenLetters.split("")) {
                    if (s.contains(br)) {
                        flag = 0;
                        break;
                    }
                }
            }
            ans += flag;
        }
        return ans;
    }
}

