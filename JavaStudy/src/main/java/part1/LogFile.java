package part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LogFile {
    //    就是给你一个log file， 让你根据每一行的第二个string来进行排序，然后只排含字母的，
//            （如果含有数字的话全都放在bottom，顺序按照原顺序不变）。这道题我是自己写了一个subclass，两个attribute，
//    id就是第一个substring， content就是第二个以及以后的sub string，
//    然后自己override一下自带的compareTo的方法，数字和字母比，就把字母放前，
//    字母和字母比，就用原生的string的compareTo，数字和数字比，就原封不动。如果字母和字母相等，
//    那就比较他们的id，用原生的compareTo。最后排序我用的bubble sort，实在没时间写快排或者merge sort了。也只过了17/24的case，也不知道错在哪儿，代码也会分享。
    public List<String> sortLog(List<String> data) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1Id = o1.indexOf(" ");
                String p1 = o1.substring(o1Id, o1.length());
                int o2Id = o2.indexOf(" ");
                String p2 = o2.substring(o2Id, o2.length());
                int index = 0;
                while (index < p1.length() && index < p2.length()) {
                    if (p1.charAt(index) == p2.charAt(index)) {
                        index++;
                        continue;
                    }
                    char a, b;
                    a = p1.charAt(index);
                    a = a >= '0' && a <= '9' ? a += 'z' : a;
                    b = p2.charAt(index);
                    b = b >= 0 && b <= 9 ? b += 'z' : b;
                    return a - b;
                }
                return p1.length() - p2.length();
            }
        };

        Collections.sort(data, comparator);
        for (String item : data) {
            System.out.println(item);
        }
        return data;

    }

    public static void main(String args[]) {
        List<String> data = new ArrayList<>();
        data.add("abcde abcdefg");
        data.add("abcde abcdeffff");
        data.add("abcde abcdegggg");
        data.add("abcde abcdef123");
        data.add("abcde abefg");
        data.add("abcde abafg");
        data.add("abcde abcfg");
        data.add("abcde dddd");
        data.add("abcde eeeee");
        new LogFile().sortLog(data);

        String t = "abcd eee";

        System.out.println('f' - 'g');
        System.out.println(Character.compare('f', '1'));
        System.out.println('1' - 0);
    }
}
