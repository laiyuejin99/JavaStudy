package algorithm;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String args[]) {
        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(23);
        treeSet.add(4);
        treeSet.add(2);
        treeSet.add(5);
        treeSet.comparator();

        for (Integer i : treeSet.descendingSet()) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(treeSet.lower(4));
        System.out.println(treeSet.floor(4));
        System.out.println(treeSet.headSet(4, false));
        System.out.println(treeSet.tailSet(4, false));

    }

}
