package leetcode;

import java.util.*;

public class N140WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<String> cur = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        dfs(s, 0, cur, res, dict);
        return res;
    }

    private void dfs(String s, int pos, List<String> cur, List<String> res, Set<String> dict) {
        if (pos == s.length()) {
            String str = listToString(cur);
            res.add(str);
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (!dict.contains(s.substring(pos, i + 1))) continue;
            cur.add(s.substring(pos, i + 1));
            dfs(s, i + 1, cur, res, dict);
            cur.remove(cur.size() - 1);
        }
    }

    private String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        //sb.append("\"");
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }


    public List<String> wordBreak2(String s, List<String> wordDict) {
        return dfs(s, new HashSet<String>(wordDict), new HashMap<String, LinkedList<String>>());
    }

    List<String> dfs(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                //remove the word length
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }


}
