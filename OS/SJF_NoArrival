import java.util.*;

public class SJF_NoArrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        System.out.println("Enter burst times:");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }

        // Sorting burst times
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (bt[i] > bt[j]) {
                    int temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;
                }
            }
        }

        wt[0] = 0;

        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
        }

        System.out.println("\nProcess\tBT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
    }
}
