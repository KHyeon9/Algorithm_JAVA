public class LeetCode3783 {
    // Mirror Distance of an Integer
    public int mirrorDistance(int n) {
        StringBuilder temp = new StringBuilder();
        temp.append(n).reverse();
        return Math.abs(n - Integer.parseInt(temp.toString()));
    }
}
