import java.util.*;

public class ProportionalAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter total number of frames: ");
        int totalFrames = sc.nextInt();

        int[] processSizes = new int[n];
        int totalSize = 0;

        System.out.println("Enter size (pages) of each process:");
        for (int i = 0; i < n; i++) {
            processSizes[i] = sc.nextInt();
            totalSize += processSizes[i];
        }

        System.out.println("\n--- Proportional Frame Allocation ---");
        for (int i = 0; i < n; i++) {
            int frames = (processSizes[i] * totalFrames) / totalSize;
            System.out.println("Process P" + (i + 1) + " -> " + frames + " frames");
        }

        sc.close();
    }
}