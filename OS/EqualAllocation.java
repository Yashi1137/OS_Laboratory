import java.util.*;

public class EqualAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter total number of frames: ");
        int totalFrames = sc.nextInt();

        int framesPerProcess = totalFrames / n;
        int remaining = totalFrames % n;

        System.out.println("\n--- Equal Frame Allocation ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Process P" + (i + 1) + " -> " + framesPerProcess + " frames");
        }

        System.out.println("Remaining frames: " + remaining);

        sc.close();
    }
}