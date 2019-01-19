package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N139 {
    public boolean wordBreak(String s, List<String> wordDict2) {
        int n = s.length();
        boolean[] canWordBreak = new boolean[n + 1];
        Set<String> wordDict = new HashSet<>();
        wordDict.addAll(wordDict2);
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for (String str : wordDict) {
            minLength = Math.min(minLength, str.length());
            maxLength = Math.max(maxLength, str.length());
        }

        boolean canjump = false;
        if (minLength > 3) {
            canjump = true;
        }

        canWordBreak[0] = true;
        for (int i = minLength; i <= n; i++) {
            for (int j = i - minLength; j >= 0 && j >= i - maxLength; j--) {
                if (canWordBreak[j] && wordDict.contains(s.substring(j, i))) {
                    canWordBreak[i] = true;
                    if (canjump)
                        i = i + minLength - 1;
                    break;
                }
            }
        }
        return canWordBreak[n];
    }

    public boolean wordBreak2(String s, List<String> wordDict2) {
        Set<String> wordDict = new HashSet<>(wordDict2);
        return dfs(s,wordDict);
    }

    public boolean dfs(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                boolean res = dfs(s.substring(word.length()), wordDict);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

}
