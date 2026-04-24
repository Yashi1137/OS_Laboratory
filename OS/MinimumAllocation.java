import java.util.*;

public class MinimumAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter total number of frames: ");
        int totalFrames = sc.nextInt();

        int[] minFrames = new int[n];
        int used = 0;

        System.out.println("Enter minimum frames required for each process:");
        for (int i = 0; i < n; i++) {
            minFrames[i] = sc.nextInt();
            used += minFrames[i];
        }

        System.out.println("\n--- Minimum Frame Allocation ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Process P" + (i + 1) + " -> " + minFrames[i] + " frames");
        }

        System.out.println("Remaining frames: " + (totalFrames - used));

        sc.close();
    }
}