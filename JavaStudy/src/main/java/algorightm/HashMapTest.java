package algorightm;

import part1.QuestionZou2_3;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapTest {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Point)) {
                return false;
            }
            Point point2 = (Point) obj;
            if (x == point2.x && y == point2.y)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return (x+","+ y).hashCode();
        }
    }

    public void test() {
        HashSet<Point> set = new HashSet<>();
        set.add(new Point(1, 1));
        set.add(new Point(1, 1));
        set.add(new Point(1, 1));
        set.add(new Point(1, 1));
        System.out.println(set.size());
    }


    public static void main(String args[]) {

        new HashMapTest().test();

    }
}
