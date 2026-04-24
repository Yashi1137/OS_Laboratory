import java.util.*;
public class WorstFit {
    public static void mian(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] blockSize=new int[m];
        int[] processSize= new int[n];
        for(int i=0;i<n;i++)
        {
            processSize[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++)
        {
            blockSize[i]=sc.nextInt();
        } 
        int[] allocation= new int[n];
        Arrays.fill(allocation,-1);
        for(int i=0;i<n;i++)
        {
            int worstIdx=-1;
            for(int j=0;j<m;j++)
            {
                if(blockSize[j]>processSize[i])
                {
                    if(worstIdx==-1||blockSize[j]>blockSize[worstIdx])
                    {
                            worstIdx=j;
                    }
                }
            }
            if(worstIdx!=-1)
            {
                allocation[i]=worstIdx;
                blockSize[worstIdx]-=processSize[i];
            }
        }
        System.out.println("Process No.\tProcess Size\tBlock No.");
        for(int i=0;i<n;i++)
        {
            System.out.println((i+1)+"\t\t"+processSize[i]+"\t\t");
            if(allocation[i]!=-1)
            {
                System.out.print(allocation[i]+1);
            }else{
                System.out.print("Not allocated");
            }
        }
        sc.close();
    }
}
