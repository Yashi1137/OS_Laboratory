import java.util.*;

public class LRU {
    public static void main(String[] args)
    {
        int[] pages= {1,2,3,4,1,2,5,1,2,3,4,5};
        int capacity=3;
        int faults=0;
        List<Integer> frames= new ArrayList<>();
        for(int page:pages)
        {
            if(!frames.contains(page))
            {
                faults++;
                if(capacity==frames.size())
                {
                    frames.remove(0);
                }
            }else{
                frames.remove(page);
            }
            frames.add(page);
            System.out.println("Frames: "+ frames);
        }
        System.out.println("Total page faults: "+faults);
    }
}
