import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Process{
    int pid,at,bt,ct,tat,wt;
    Process(int pid,int at,int bt){
        this.pid=pid;
        this.at=at;
        this.bt=bt;
    }
}

public class FCFS {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Number of processes:");
        int n=sc.nextInt();
        Process[] p = new Process[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the AT and BT for "+(i+1)+" Process: ");
            int at=sc.nextInt();
            int bt=sc.nextInt();
            p[i]= new Process(i+1, at, bt);
        }
        Arrays.sort(p,Comparator.comparingInt(a->a.at));
        int time=0;
        double ttat=0,twt=0;
        for(int i=0;i<n;i++)
        {
            if(time<p[i].at)
            {
                time=p[i].at;
            }
            time=time+p[i].bt;
            p[i].ct=time;
            p[i].tat=p[i].ct-p[i].at;
            p[i].wt=p[i].tat-p[i].bt;
            ttat+=p[i].tat;
            twt+=p[i].wt;
        }
        System.out.println("\nPID\tAT\tBT\tCT\tTAT\twt");
        for(int i=0;i<n;i++)
        {
            System.out.println("P"+p[i].pid+"\t"+p[i].at+"\t"+p[i].bt+"\t"+p[i].ct+"\t"+p[i].tat+"\t"+p[i].wt);
        }
        System.out.printf("The Average Turn Around Time (ATAT) is %.2f\n",ttat/n);
        System.out.printf("The Average Waiting Time (AWT) is %.2f\n",twt/n);
        sc.close();

    }
}