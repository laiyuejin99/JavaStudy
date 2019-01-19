package algorightm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueStudy {

	public static void main(String[] args) {
		   PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(4,new Comparator<Integer>() {
	            @Override
	            public int compare(Integer o1, Integer o2) {
	                return o1-o2;
	            }
	        });
	        priorityQueue.add(89);
	        priorityQueue.add(2);
	        priorityQueue.add(3);
	        priorityQueue.add(3);
	        priorityQueue.add(3);
	        priorityQueue.add(5);
	        priorityQueue.add(1);
			Object []arr = priorityQueue.toArray();
			while(!priorityQueue.isEmpty()){
				System.out.println(priorityQueue.poll());
			}


//			for(int i = 0;i<arr.length;i++){
//				System.out.println(arr[i]);
//			}

	}

}
