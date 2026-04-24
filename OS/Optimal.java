import java.util.*;
public class Optimal {
    public static void main(String[] args) {
        int[] pages= { 1,2,3,4,1,2,5,1,2,3,4,5};
        int capacity=3;
        List<Integer> frames= new ArrayList<>();
        int faults=0;
        for(int i=0;i<pages.length;i++)
        {
            int page=pages[i];
            if(!frames.contains(page))
            {
                faults++;
                if(capacity>frames.size())
                {
                    frames.add(page);
                }else{
                    int indexToRemove=-1;
                    int farthest=i;
                    for(int j=0;j<frames.size();j++)
                    {
                        int k;
                        for(k=i+1;k<pages.length;k++)
                        {
                            if(frames.get(j)==pages[k])
                            {
                                if(farthest<k)
                                {
                                    farthest=k;
                                    indexToRemove=j;
                                }
                                break;
                            }
                        }
                        if(k==pages.length)
                        {
                            indexToRemove=j;
                            break;
                        }
                    }
                    frames.set(indexToRemove,page);
                }
            }
            System.out.println("Frames: "+frames);
        }
        System.out.println("Total faults: "+faults);
    }
}
