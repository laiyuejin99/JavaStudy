package part1;

import java.util.*;

public class CountString {
    public List<String> count(String str, int k) {
        String[] words = str.toLowerCase().split("\\W+");
        for(String item : words){
            System.out.print(item +"  ");
        }

        HashMap<String, Integer> sumHash = new HashMap<>();
        TreeMap<Integer, Set<String>> topK = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (String key : words) {
            if (sumHash.containsKey(key)) {
                int sum = sumHash.get(key);
                Set set = topK.get(sum);
                set.remove(key);
                Set set2 = topK.get(sum + 1);
                if (set2 == null) {
                    set2 = new HashSet();
                }
                set2.add(key);
                topK.put(sum + 1, set2);
                sumHash.put(key, ++sum);
            } else {
                sumHash.put(key, 1);
                Set<String> set = topK.get(1);
                if (set == null)
                    set = new HashSet<>();
                set.add(key);
                topK.put(1, set);
            }
        }
        List<String> result = new ArrayList<>();
        Iterator<Integer> iterator = topK.keySet().iterator();
        int count = k;
        while (count > 0 && iterator.hasNext()) {
            int ke = iterator.next();
            System.out.println("key  = " + ke);
            Set<String> set = topK.get(ke);
            count -= set.size();
            result.addAll(set);
        }
        return result;
    }

    public static void main(String args[]) {
        String paragraph = "I am Jack and my father is Jimmy. I like wearing Jack and Jone's";
        List<String> res = new CountString().count(paragraph, 1);
        System.out.println(res.size());
        for (String s : res) {
            System.out.println(s);
        }
    }

}
