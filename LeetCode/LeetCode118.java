import java.util.*;

public class LeetCode118 {
    // Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int row = 0; row < numRows ; row++) {
            List<Integer> list = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                // 양 끝값은 1로 지정
                if (col == 0 || col == row) {
                    list.add(1);
                } else {
                    // 양 끝값이 아니면 이전 리스트의 왼쪽과 오른쪽 값을 더해서 저장
                    List<Integer> temp = res.get(row - 1);
                    list.add(temp.get(col - 1) + temp.get(col));
                }
            }
            res.add(list);
        }
        return res;
    }
}
