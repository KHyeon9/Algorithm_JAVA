public class LeetCode2011 {
    // Final Value of Variable After Performing Operations
    public int finalValueAfterOperations(String[] operations) {
        int answer = 0;
        for (String operation : operations) {
            if (operation.contains("+")) {
                answer++;
            } else {
                answer--;
            }
        }
        return answer;
    }
}

