public class LeetCode3516 {
    // Find Closest Person
    public int findClosest(int x, int y, int z) {
        int firstDist = Math.abs(x - z);
        int secondDist = Math.abs(y - z);

        if (firstDist < secondDist) {
            return 1;
        } else if (firstDist > secondDist) {
            return 2;
        } else {
            return 0;
        }
    }
}

