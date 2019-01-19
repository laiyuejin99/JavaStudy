package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result,candidates,target,0,new ArrayList<>(),0);
        return result;
    }

    public void helper(List<List<Integer>> result, int[] candidates, int target, int currentSum, List<Integer> temp,int start) {
        if (currentSum == target) {
            List<Integer> item = new ArrayList<>();
            item.addAll(temp);
            result.add(item);
        } else if (currentSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            boolean flag;
            temp.add(candidates[i]);
            helper(result,candidates,target,currentSum+candidates[i],temp,start);
            temp.remove(temp.size()-1);
        }
    }
}
