package part1;

import java.util.*;

public class Question1 {


    public class Solution {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
            if(literatureText==null||literatureText.length()==0) return new ArrayList();
            Set<String> excludeWord = new HashSet<>();
            for (String item:wordsToExclude){
                excludeWord.add(item.toLowerCase());
            }

            excludeWord.add(".");
            excludeWord.add("?");
            excludeWord.add(">");
            excludeWord.add("!");
            excludeWord.add("'");
            HashMap<String, Integer> calculateSum = new HashMap<>();
            int max = -1;
            String allWords[] = literatureText.toLowerCase().split("\\W+");
//            String allWords[] = literatureText.toLowerCase().split(" |,|\\.");
            for (String item : allWords) {
                if (excludeWord.contains(item)||item.equals(".")){
                    continue;
                }
                if (calculateSum.containsKey(item)) {
                    int sum = calculateSum.get(item) + 1;
                    calculateSum.put(item, sum);
                    max = Math.max(sum, max);
                } else {
                    calculateSum.put(item, 1);
                    max = Math.max(1, max);
                }
            }
            List<String> result = new ArrayList<>();
            for (String item : calculateSum.keySet()) {
                int sum = calculateSum.get(item);
                if (sum == max) {
                    result.add(item);
                }
            }
            return result;
        }
    }

    public static void main(String args[]){
        String test = "I am Jack and my father is Jimmy. . . I like wearing Jack and Jone's";

    }
}
