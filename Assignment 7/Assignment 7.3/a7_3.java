// Write a Java Program to implement paging simulation using
// 1. FIFO
// 2. Least Recently Used (LRU)
// 3. Optimal algorithm

// Optimal Algorithm


import java.util.Scanner;

public class a7_3 {

    static boolean search(int key, int[] fr) {
        for (int i = 0; i < fr.length; i++)
            if (fr[i] == key)
                return true;
        return false;
    }

    static int predict(int pg[], int[] fr, int pn, int index) {
        int res = -1, farthest = index;
        for (int i = 0; i < fr.length; i++) {
            int j;
            for (j = index; j < pn; j++) {
                if (fr[i] == pg[j]) {
                    if (j > farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }

            if (j == pn)
                return i;
        }

        return (res == -1) ? 0 : res;
    }

    static void optimalPage(int pn, int fn) {
    Scanner scanner = new Scanner(System.in);

    int[] fr = new int[fn];
    int[] pg = new int[pn];
    int hit = 0;
    int index = 0;

    System.out.println("Enter page numbers:");
    for (int i = 0; i < pn; i++) {
        pg[i] = scanner.nextInt();
    }

    System.out.println("No. of frames: " + fn);

    System.out.println("\nPage Simulation:");
    System.out.println("----------------");

    for (int i = 0; i < pn; i++) {
        System.out.print("Page " + pg[i] + " -> ");
        if (search(pg[i], fr)) {
            hit++;
            System.out.println("Hit");
            continue;
        }

        if (index < fn) {
            fr[index++] = pg[i];
            System.out.print("Miss [");
        } else {
            int j = predict(pg, fr, pn, i + 1);
            fr[j] = pg[i];
            System.out.print("Miss [");
        }

        // Print the current frames
        for (int k = 0; k < fn; k++) {
            if (k != 0) {
                System.out.print(", ");
            }
            System.out.print(fr[k]);
        }
        System.out.println("]");
    }

    System.out.println("\nNo. of hits = " + hit);
    System.out.println("No. of misses = " + (pn - hit));
    scanner.close();
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of pages:");
        int pn = scanner.nextInt();

        System.out.println("Enter the number of frames:");
        int fn = scanner.nextInt();

        optimalPage(pn, fn);
        scanner.close();
    }
}
