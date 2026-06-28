public class LeetCode404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        // 해당 노드가 null인 경우 0
        if (root == null) return 0;
        // 현재 왼쪽 리프 노드 합 변수
        int total = 0;
        // 왼쪽 리프 노드인 경우 더하기
        if (root.left != null &&
                root.left.left == null &&
                root.left.right == null) {
            total += root.left.val;
        }
        // 재귀로 양쪽 확인
        total += sumOfLeftLeaves(root.left);
        total += sumOfLeftLeaves(root.right);
        // 결과 반환
        return total;
    }
}
