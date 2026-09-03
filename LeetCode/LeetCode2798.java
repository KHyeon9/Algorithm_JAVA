import java.util.Arrays;

public class LeetCode2798 {
    // Number of Employees Who Met the Target
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).filter(h -> h >= target).count();
    }
}

