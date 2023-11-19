// Write a program to simulate CPU Scheduling Algorithms: FCFS, SJF,
// Priority and Round Robin.

// First Come First Served

import java.util.*;
import java.io.*;

public class a5_1{
    public static void main(String[] args) {
        int n, sum = 0;
        float total_tt =0, total_waiting = 0;

        Scanner p = new Scanner(System.in);
        System.out.println("\nEnter Number of Process: ");
        n = p.nextInt();

        int arrival[] = new int[n];
        int cpu[] = new int[n];
        int finish[] = new int[n];
        int turntt[] = new int[n];
        int wait[] = new int[n];
        int process[] = new int[n];

        for (int i = 0; i < n; i++){
            System.out.println("\nEnter arrival time of "+(i+1)+" process: ");
            arrival[i] = p.nextInt();

            System.out.println("\nEnter CPU time of "+(i+1)+" process: ");
            cpu[i] = p.nextInt();

            process[i] = i+1;
        }

        for (int i =0; i < n; i++){
            sum = sum + cpu[i];
            finish[i] = sum;    //finish time of each process
        }

        for (int i=0; i<n; i++){
            turntt[i] = finish[i] - arrival[i];     //turnaround time = finish time - arrival time
            total_tt = total_tt + turntt[i];        //total turnaround time
            wait[i] = turntt[i] + cpu[i];           //waiting time = turnaround time - cpu time
            total_waiting += wait[i];               //total waiting time
        }

        System.out.println("\n\nProcess ID\tArrival Time\tBurst Time\tWaiting Time\tTurn Around Time");
        for (int i=0; i<n; i++){
            System.out.println(process[i]+"\t\t"+arrival[i]+"\t\t"+cpu[i]+"\t\t"+wait[i]+"\t\t"+turntt[i]);
        }
        System.out.println("\n\nAverage Turn Around Time is: "+ (total_tt/n));
        System.out.println("\n\nAverage Waiting Time is: "+ (total_waiting/n)+"\n");
        p.close();
    }
}


