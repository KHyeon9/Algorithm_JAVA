public class LeetCode14 {
    // Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefixTemp = new StringBuilder();
        String prefix ="";

        for (String ch : strs[0].split("")) {
            boolean flag = true;
            prefixTemp.append(ch);
            for (String str : strs) {
                if (!str.startsWith(prefixTemp.toString())) {
                    flag = false;
                    break;
                }
            }
            if (flag) prefix =  prefixTemp.toString();
            else return prefix;
        }

        return prefix;
    }
}

