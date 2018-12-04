package algorightm;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1, 2);
        System.out.println(list);
        list.remove(new Integer(1));//System.arraycopy
        list.remove(1);// System.arraycopy is faster
        list.clone();
        list.lastIndexOf(new Integer(1));
        list.spliterator();
    }
}
