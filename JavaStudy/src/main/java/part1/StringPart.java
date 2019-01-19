package part1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPart {
//    1. Given a string and an integer K, return a list of substring with exactly k distinct characters.
//2. Write a function which will partition a sequence of labels into minimal subsequences. 意思就是给一个char数组，把它拆分成多个部分，每个部分中的char不能再在其他部分中出现。return 每个部分的长度.. 围观我们@1point 3 acres
//    test case: [a, b, c, d, a, e, f, g, h, i, j]
//            [a, b, c, d, a, / e, f, g, h, i, j]
//            return 5, 6


    public static List<String> differnWords(String input, int k) {
        if (k > input.length()) return null;
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < input.length() - k; i++) {
            String temp = input.substring(i, i + k);

            // will need a menthod to determine if there is dulipcated chars
            Set<String> set = new HashSet<String>();
            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                set.add(Character.toString(c));
            }
            // if set size equals to k, then add the sub string into result
            if (set.size() == k && !result.contains(temp)) {
                result.add(temp);
            }
        }

        for (String str : result) {
            System.out.print(str + " ");
        }
        return result;
    }

    public static void main(String arts[]) {
        String abcd = "aaabcdefa";
        new StringPart().partString();
    }

    public void partString() {
        List<Character> l = new ArrayList<Character>();

        l.add('a');
        l.add('b');
        l.add('a');
        l.add('b');
        l.add('c');
        l.add('b');
        l.add('a');
        l.add('c');
        l.add('a');
        l.add('d');
        l.add('e');
        l.add('f');
        l.add('e');
        l.add('g');
        l.add('d');
        l.add('e');
        l.add('h');
        l.add('i');
        l.add('j');
        l.add('h');
        l.add('k');
        l.add('l');
        l.add('i');
        l.add('j');
//ababcbacadefegdeh
        List<Integer> data = charPartition1(l);
        System.out.println("result = " + data);
    }

    public static List<Integer> charPartition1(List<Character> data) {
        List<Integer> result = new ArrayList<Integer>();
        Set<Character> set = new HashSet<>();
        Set<Character> temp = new HashSet<>();
        int indexEnd = 0;
        for (int index1 = 0; index1 < data.size(); index1 = indexEnd) {
            int count = 1;
            set.add(data.get(index1));
            for (int i = index1; i < data.size(); i++) {
                Character c = data.get(i);
                if (!temp.contains(c)) {
                    temp.add(c);
                }
                if (set.contains(c)) {
                    set.addAll(temp);
                    temp.clear();
                    count = i - index1 + 1;
                    indexEnd = i;
                }
            }
            indexEnd++;
            result.add(count);
            temp.clear();
            set.clear();
        }
        return result;
    }

    public static List<Integer> charPartition(List<Character> l) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < l.size(); i++) {
            List<Character> l1 = l.subList(0, i);
            List<Character> l2 = l.subList(i, l.size());

            for (int j = 0; j < l1.size(); j++) {
                if (l2.contains(l1.get(j))) {
                    break;
                } else if (!l2.contains(l1.get(j)) && j == l1.size() - 1) {
                    result.add(i);
                }
            }
        }

        List<Integer> _r = new ArrayList<Integer>();
        _r.add(result.get(0));
        if (result.size() > 1) {
            for (int i = 1; i < result.size(); i++) {
                int _t = result.get(i) - result.get(i - 1);
                _r.add(_t);
            }
        }
        _r.add(l.size() - result.get(result.size() - 1));
        for (Integer i : _r) {
            System.out.println(i);
        }

        return _r;
    }

}
