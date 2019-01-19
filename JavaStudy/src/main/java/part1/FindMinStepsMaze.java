package part1;

import java.util.ArrayList;
import java.util.List;

public class FindMinStepsMaze {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null||s.length() == 0||p == null||p.length()==0)
            return result;
        int[] hash = new int[256];
        char[] pp = p.toCharArray();
        for(char i:pp){
            hash[i]++;
        }
        int left = 0, right = 0, count = p.length();
        while(right < s.length())
        {
            if(hash[s.charAt(right++)]-- > 0)
                count--;
            if(count == 0)
                result.add(left);
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
                //如果当窗口大小一定的时候即窗口大小和需要比较的字符串大小一致的时候，将窗口左边的指针向右边移动，移动的同时左边的字符计数因为在第一个if的地方hash值减小过，所以需要执行对应恢复操作，即：hash值增加，count计数值增加。
                count++;
        }
        return result;

    }

}
