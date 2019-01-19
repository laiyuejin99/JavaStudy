package leetcode;

import java.util.ArrayList;
import java.util.List;

public class N118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> topList = result.get(i - 1);
            List<Integer> curList = new ArrayList<>(topList.size() + 1);
            for (int j = 0; j < topList.size() + 2; j++) {
                int topLeft = 0, topRight = 0;
                if (j - 1 >= 0) {
                    topLeft = topList.get(j - 1);
                }
                if (j < topList.size()) {
                    topRight = topList.get(j);
                }
                curList.add(topLeft + topRight);
            }
            result.add(curList);
        }
        return result;
    }
}
