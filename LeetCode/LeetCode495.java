public class LeetCode495 {
    // Teemo Attacking
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // 독 지속 시간과 다음 시간을 비교해 작은 것 더함
        int poisonTime = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int gap = timeSeries[i + 1] - timeSeries[i];
            poisonTime += Math.min(gap, duration);
        }
        // 마지막 시간에 무조건 duration만큼 지속됨
        poisonTime += duration;
        return poisonTime;
    }
}
