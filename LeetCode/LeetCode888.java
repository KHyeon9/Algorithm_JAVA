public class LeetCode888 {
    // Fair Candy Swap
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int alice = 0, bob = 0;

        for (int size : aliceSizes) alice += size;
        for (int size : bobSizes) bob += size;

        for (int aliceSize : aliceSizes) {
            for (int bobSize : bobSizes) {
                int aliceTemp = alice - aliceSize + bobSize;
                int bobTemp = bob - bobSize + aliceSize;
                if (aliceTemp == bobTemp) {
                    return new int[]{aliceSize, bobSize};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

