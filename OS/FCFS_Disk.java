import java.util.*;

public class FCFS_Disk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of requests: ");
        int n = sc.nextInt();

        int[] req = new int[n];
        System.out.println("Enter request sequence:");
        for (int i = 0; i < n; i++) {
            req[i] = sc.nextInt();
        }

        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        int seekCount = 0;

        System.out.print("\nSeek Sequence: " + head);

        for (int i = 0; i < n; i++) {
            seekCount += Math.abs(req[i] - head);
            head = req[i];
            System.out.print(" -> " + head);
        }

        System.out.println("\nTotal Seek Operations: " + seekCount);
        sc.close();
    }
}
