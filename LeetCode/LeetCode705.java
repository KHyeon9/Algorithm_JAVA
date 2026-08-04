public class LeetCode705 {
    // Design HashSet
    class MyHashSet {
        boolean[] nums;

        public MyHashSet() {
            nums = new boolean[1000001];
        }

        public void add(int key) {
            nums[key] = true;
        }

        public void remove(int key) {
            nums[key] = false;
        }

        public boolean contains(int key) {
            return nums[key];
        }
    }
}
