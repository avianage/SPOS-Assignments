// Write a program to simulate CPU Scheduling Algorithms: FCFS, SJF,
// Priority and Round Robin.

// Shortest Job First

import java.util.*;

public class a5_2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println ("\nEnter no of process:");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n]; // at means arrival time
        int bt[] = new int[n]; // bt means burst time
        int ct[] = new int[n]; // ct means complete time
        int ta[] = new int[n]; // ta means turn around time
        int wt[] = new int[n];  //wt means waiting time
        int f[] = new int[n];  // f means it is flag it checks process is completed or not
        int st=0, tot=0;
        float avgwt=0, avgta=0;
 
        for (int i = 0; i < n; i++){
            System.out.println("\nEnter process "+ (i+1)+" arrival time: ");
            at[i] = sc.nextInt();
            
            System.out.println("\nEnter process "+ (i+1)+" burst time: ");
            bt[i] = sc.nextInt();

            pid[i] = i+1;
            f[i] = 0;
        }

        boolean a = true;
        while (a){
            int c = n, min = 999;

            if (tot == n ){
                break;
            }

            for (int i = 0 ; i < n; i++){
                if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min) ){
                    min = bt[i];
                    c = i;
                }
            }
            if (c == n){
                st++;
            }
            else {
                ct[c] = st + bt[c];
                st += bt[c];

                ta[c] = ct[c] - at[c];
                wt[c] = ta[c] - bt[c];
                f[c] = 1;
                tot++;
            }
        }

        System.out.println("\nP ID \t\t Arrival Time \t\t Brust Time \t\t Turnaround Time \t\t Waiting Time");
        for(int i=0;i<n;i++){
            avgwt+= wt[i];
            avgta+= ta[i];
            System.out.println(pid[i]+"\t\t"+at[i]+"\t\t\t"+bt[i]+"\t\t\t"+ta[i]+"\t\t\t\t"+wt[i]);
        }
        System.out.println ("\nAverage tat is "+ (float)(avgta/n));
        System.out.println ("Average wt is "+ (float)(avgwt/n));
        sc.close();
    }
}