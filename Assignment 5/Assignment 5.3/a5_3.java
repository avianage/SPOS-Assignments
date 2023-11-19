// Write a program to simulate CPU Scheduling Algorithms: FCFS, SJF,
// Priority and Round Robin.

// Priority

import java.util.*;

class Process {
    int pid;
    int burstTime;
    int priority;
    int waitingTime;
    int turnAroundTime;

    public Process(int pid, int burstTime, int priority){
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
    }

}

public class a5_3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Process> processes = new ArrayList<>();

        System.out.print("\nEnter number of processes: ");
        int numProcess = scanner.nextInt();

        for (int i = 1; i <= numProcess; i++){
            System.out.println("Enter burst time for Process: " + i + ": ");
            int burstTime = scanner.nextInt();

            System.out.print("Enter priority for Process " + i + ": ");
            int priority = scanner.nextInt();

            processes.add(new Process(i, burstTime, priority));
        }
        
        Collections.sort(processes, Comparator.comparingInt(p->p.priority));

        int currentTime = 0;

        for (Process process: processes){
            process.waitingTime = currentTime;
            currentTime += process.burstTime;
            process.turnAroundTime = process.waitingTime + process.burstTime;
        }

        System.out.println("Process\t\tBurst Time\t\tPriority\t\tWaiting Time\t\tTurnaround Time");
        for (Process process : processes) {
            System.out.println(process.pid + "\t\t" + process.burstTime + "\t\t\t" + process.priority + "\t\t\t"
                    + process.waitingTime + "\t\t\t" + process.turnAroundTime);
        }

        double avgWaitingTime = processes.stream().mapToDouble(p -> p.waitingTime).average().orElse(0);
        double avgTurnaroundTime = processes.stream().mapToDouble(p -> p.turnAroundTime).average().orElse(0);

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("\nAverage Turnaround Time: " + avgTurnaroundTime);

        scanner.close();
    }
}