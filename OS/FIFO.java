import java.util.*;

public class FIFO {
    public static void main(String[] args) {
        int[] pages={1,2,3,4,1,2,5,1,2,3,4,5};
        int capacity=3;
        Queue<Integer> queue= new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        int faults=0;
        for(int page: pages)
        {
            if(!set.contains(page))
            {
                faults++;
                if(queue.size()==capacity)
                {
                    int removed=queue.poll();
                    set.remove(removed);
                }
                set.add(page);
                queue.add(page);
            }
            System.out.println("Frames: "+queue);
        }
        System.out.println("Total No. of Faults: "+ faults );
    }
}
