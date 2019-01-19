package part1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class QuestionZou1 {
    public static class Location {
        public int x;
        public int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x+"  "+y;
        }
    }

    List<List<Integer>> nearestXsteakHouses(int totalSteakhouses, List<List<Integer>> allLocations, int numSteakhouses) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Location> topKHeap = new PriorityQueue<>(new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                return -o1.x * o1.x + o1.y * o1.y - o2.x * o2.x - o2.y * o2.y;
            }
        });

        for (int i = 0; i < allLocations.size(); i++) {
            List<Integer> item = allLocations.get(i);
            Location location = new Location(item.get(0), item.get(1));
            topKHeap.offer(location);
            if (topKHeap.size() > numSteakhouses) {
                topKHeap.poll();
            }
        }

        while (!topKHeap.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            Location location = topKHeap.poll();
            item.add(location.x);
            item.add(location.y);
            result.add(item);
        }
        return result;
    }

    public static void main(String args[]){
        PriorityQueue<Location> topKHeap = new PriorityQueue<>(new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                return  o2.x * o2.x + o2.y * o2.y-o1.x * o1.x - o1.y * o1.y;
            }
        });
        topKHeap.offer(new Location(2,4));
        topKHeap.offer(new Location(3,6));
        System.out.println(topKHeap.poll());
        System.out.println(topKHeap.poll());

    }
}
