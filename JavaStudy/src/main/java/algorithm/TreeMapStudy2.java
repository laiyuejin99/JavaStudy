package algorithm;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapStudy2 {
    public static void main(String args[]){
        TreeMap<Integer,String> tm = new TreeMap<Integer, String>();

        tm.put(0, "zero");
        tm.put(1, "one");
        tm.put(3, "three");
        tm.put(2, "two");

        SortedMap<Integer,String> re =  tm.headMap(2,true);
        System.out.println("head map 2 = "+re);
        System.out.println("tail map2 ="+tm.tailMap(2));

        Map.Entry<Integer,String> res = tm.ceilingEntry(-1);
        System.out.println(res);

        System.out.println(tm.floorKey(5));
        System.out.println(tm.lowerKey(4));
        System.out.println(tm.higherEntry(-1));
        System.out.println(tm.higherEntry(-1));

//        Set<Integer> keys = tm.keySet();// set本身就是一个集合
//        for (Integer key : keys) {
//            System.out.print("学号：" + key + ",姓名：" + tm.get(key) + "\t");
//        }
    }
}
