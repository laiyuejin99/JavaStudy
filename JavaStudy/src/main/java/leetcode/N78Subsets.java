package leetcode;

import java.util.ArrayList;
import java.util.List;

public class N78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),0,nums);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> temp,int start,int []nums){
        List<Integer> item = new ArrayList<>();
        item.addAll(temp);
        res.add(item);
        if(start >= nums.length) return;

        for(int i = start;i<nums.length;i++){
            temp.add(nums[i]);
            helper(res,temp,i+1,nums);
            temp.remove(temp.size()-1);
        }
    }
}
