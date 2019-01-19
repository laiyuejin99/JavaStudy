package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class N17PhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wzyz");


        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        helper(map, digits.toCharArray(), 0, builder, res);
        return res;
    }


    public void helper(HashMap<Character, String> map, char[] digit, int index, StringBuilder builder, List<String> result) {
        if (index == digit.length) {
            result.add(builder.toString());
            return;
        }
        char c = digit[index];
        char[] strCombina = map.get(c).toCharArray();
        for (int i = 0; i < strCombina.length; i++) {
            builder.append(strCombina[i]);
            helper(map, digit, index+1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String arts[]){
        System.out.println(new N17PhoneNumber().letterCombinations("23"));
    }



}
