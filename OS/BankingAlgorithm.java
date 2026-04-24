public class BankingAlgorithm {

    public static void main(String[] args) {

        int n = 5; // number of processes
        int r = 3; // number of resources

        int[][] alloc = {
            {0, 0, 1}, // P0
            {3, 0, 0}, // P1
            {1, 0, 1}, // P2
            {2, 3, 2}, // P3
            {0, 0, 3}  // P4
        };

        int[][] max = {
            {7, 6, 5},
            {3, 2, 2},
            {8, 0, 2},
            {2, 1, 2},
            {5, 2, 3}
        };

        int[] avail = {2, 3, 2};

        int[] f = new int[n];     // finished array
        int[] ans = new int[n];   // safe sequence
        int ind = 0;

        int[][] need = new int[n][r];

        // 🔹 Calculate NEED matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < r; j++) {
                need[i][j] = max[i][j] - alloc[i][j];
            }
        }

        // 🔹 Banker's Algorithm Logic
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (f[i] == 0) {
                    boolean canExecute = true;

                    for (int j = 0; j < r; j++) {
                        if (need[i][j] > avail[j]) {
                            canExecute = false;
                            break;
                        }
                    }

                    if (canExecute) {
                        ans[ind++] = i;

                        for (int j = 0; j < r; j++) {
                            avail[j] += alloc[i][j];
                        }

                        f[i] = 1;
                    }
                }
            }
        }

        // 🔹 Check if safe
        if (ind < n) {
            System.out.println("System is NOT in safe state");
        } else {
            System.out.println("System is in SAFE state");
            System.out.print("Safe Sequence: ");
            for (int i = 0; i < n - 1; i++) {
                System.out.print("P" + ans[i] + " -> ");
            }
            System.out.println("P" + ans[n - 1]);
        }
    }
}