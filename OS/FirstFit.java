import java.util.*;
public class FirstFit {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] blockSize= new int[m];
        int[] processSize= new int[n];
        for(int i=0;i<m;i++)
        {
            blockSize[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            processSize[i]=sc.nextInt();
        }
        int[] allocation=new int[n];
        Arrays.fill(allocation,-1);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(blockSize[j]>=processSize[i])
                {
                    allocation[i]=j;
                    blockSize[j]-=processSize[i];
                    break;
                }
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
