package leetcode;

import java.util.ArrayList;
import java.util.List;

public class N89GreyCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i^i>>1);
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(1^1>>1);
    }

}
