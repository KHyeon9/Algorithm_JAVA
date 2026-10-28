import java.util.*;

public class LeetCode2418 {
    // Sort the People
    class People {
        String name;
        int height;
        public People(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        List<People> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new People(names[i], heights[i]));
        }
        list.sort(Comparator.comparingInt(o -> -o.height));
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).name;
        }
        return res;
    }
}

