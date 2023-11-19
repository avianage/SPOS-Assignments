// Write a Java Program to implement paging simulation using
// 1. FIFO
// 2. Least Recently Used (LRU)
// 3. Optimal algorithm

// First In First Out

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class a7_1 {
    // Method to find page faults using FIFO
    static int pageFaults(int pages[], int n, int capacity) {
        HashSet<Integer> s = new HashSet<>(capacity);
        Queue<Integer> indexes = new LinkedList<>();
        int page_faults = 0;

        for (int i = 0; i < n; i++) {
            if (s.size() < capacity) {
                if (!s.contains(pages[i])) {
                    s.add(pages[i]);
                    page_faults++;
                    indexes.add(pages[i]);
                }
            } else {
                if (!s.contains(pages[i])) {
                    int val = indexes.peek();
                    indexes.poll();
                    s.remove(val);
                    s.add(pages[i]);
                    indexes.add(pages[i]);
                    page_faults++;
                }
            }

            // Print page access and frames
            System.out.print("Page " + pages[i] + " -> ");
            for (int page : indexes) {
                System.out.print(page + " ");
            }
            System.out.println();
        }

        return page_faults;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of pages: ");
        int n = input.nextInt();
        int pages[] = new int[n];

        System.out.println("Enter the page numbers:");
        for (int i = 0; i < n; i++) {
            pages[i] = input.nextInt();
        }

        System.out.print("Enter the number of frames: ");
        int capacity = input.nextInt();

        input.close();

        int pageFaults = pageFaults(pages, n, capacity);
        System.out.println("\nTotal Page Faults: " + pageFaults);
    }
}
