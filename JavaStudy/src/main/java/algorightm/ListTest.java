package algorightm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTest {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>(5);
//        list.s
//        list.add(1);
//        list.add(1, 2);
//        System.out.println(list);
//        list.remove(new Integer(1));//System.arraycopy
//        list.remove(1);// System.arraycopy is faster
//        list.clone();
//        list.lastIndexOf(new Integer(1));
//        list.spliterator();
//        ArrayList<String> stringList = new ArrayList<>(3);
//        stringList.add("abcd");
//        System.out.println(stringList.get(0));
//        System.out.println(stringList.get(1));
//        System.out.println(stringList.get(0));
//        String a[] = new String[23];
//        a[0] = a[0] + "abc";
//        ArrayList<String> test = new ArrayList<String>();
//        test.addAll(Arrays.asList(a));
//        System.out.println(test);

        list.add(1);
        list.add(2);
        list.add(3);
        Collections.reverse(list);
        System.out.println(list);

    }


    public List<String> fizzBuzz(int n) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = "";
        }
        int index = 1;
        while (index * 5 - 1 < n) {
            res[index * 3 - 1] = "Fizz";
            index++;
        }
        index = 1;
        while (index * 5 - 1 < n) {
            res[index * 5 - 1] = res[index * 5 - 1] + "Buzz";
            index++;
        }
        for (int i = 0; i < n; i++) {
            if (res[i].equals("")) {
                res[i] = i + 1 + "";
            }
        }
        return Arrays.asList(res);

    }
}
