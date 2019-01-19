package leetcode;

public class N58LengthofLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        char cs[] = s.toCharArray();
        int length = 0;
        int index = s.length() - 1;
        while (index >= 0 && cs[index] != ' ') {
            index--;
            length++;
        }
        return length;
    }
}
