public class LeetCode2485 {
    // Find the Pivot Integer
    public int pivotInteger(int n) {
        int sum = 0;
        int[] sumArr =  new int[n + 1];

        for(int i = 1; i <= n; i++){
            sum += i;
            sumArr[i] = sum;
        }

        for(int i = 1; i <= n; i++){
            if(sumArr[i] == sum - sumArr[i - 1]){
                return i + 1;
            }
        }
        return -1;
    }
}

