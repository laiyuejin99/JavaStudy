package algorithm;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeMapStudy1<I extends Number, S> {

    public static void main(String argsp[]) {
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("!23", 1));
        ts.add(new Person("张三", 23));
        ts.add(new Person("李四", 13));
        ts.add(new Person("周七", 13));
        ts.add(new Person("王五", 43));
        ts.add(new Person("赵六", 33));

        System.out.println(ts);



        //需求:将字符串按照长度排序
        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });        //Comparator c = new CompareByLen();
        ts2.add("aaaaaaaa");
        ts2.add("z");
        ts2.add("wc");
        ts2.add("nba");
        ts2.add("cba");

        System.out.println(ts2);






    }

    private static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int compareTo(Person o) {
            return age - o.age;
        }

        @Override
        public String toString() {
            return name + age;
        }
    }
}
