import java.util.*;

public class LeetCode704 {
    // Binary Search
    public int search(int[] nums, int target) {
        // 각 위치 저장
        int left = 0, right = nums.length - 1;
        // 이분 탐색
        while (left <= right) {
            int mid = (left + right) / 2;
            // 값을 찾은 경우
            if (nums[mid] == target) {
                return mid;
            }
            // 목표가 더 큰 경우와 작은 경우 다르게 처리
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
