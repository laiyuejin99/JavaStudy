package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class N46Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> temp, int nums[], boolean used[]) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                helper(result, temp, nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
