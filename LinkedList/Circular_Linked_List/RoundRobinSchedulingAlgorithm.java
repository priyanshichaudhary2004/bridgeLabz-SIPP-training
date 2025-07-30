import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;

    // Add process at the end of the circular list
    public void addProcess(int id, int burst, int priority) {
        Process newProcess = new Process(id, burst, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    // Remove process by ID
    public void removeProcess(int id) {
        if (head == null) return;

        Process curr = head, prev = null;
        do {
            if (curr.processId == id) {
                if (curr == head) {
                    Process last = head;
                    while (last.next != head)
                        last = last.next;

                    if (head.next == head) {
                        head = null;
                    } else {
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Simulate round-robin scheduling
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        Process current = head;
        boolean done;
        System.out.println("\n--- Starting Round Robin Scheduling ---");

        while (true) {
            done = true;
            Process temp = current;

            do {
                if (temp.remainingTime > 0) {
                    done = false;

                    int execTime = Math.min(timeQuantum, temp.remainingTime);
                    System.out.println("Process " + temp.processId + " executes for " + execTime + " units.");
                    time += execTime;
                    temp.remainingTime -= execTime;

                    if (temp.remainingTime == 0) {
                        temp.turnaroundTime = time;
                        temp.waitingTime = temp.turnaroundTime - temp.burstTime;
                        System.out.println("Process " + temp.processId + " completed.");
                    }
                }
                temp = temp.next;
            } while (temp != current);

            displayProcesses();

            if (done) break;
        }

        calculateAverageTimes();
    }

    // Display all processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes.");
            return;
        }

        Process temp = head;
        System.out.println("\nProcesses after round:");
        do {
            System.out.println("ID : " + temp.processId + ", Remaining Time : " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Calculate and display average times
    public void calculateAverageTimes() {
        int totalWT = 0, totalTAT = 0, count = 0;

        if (head == null) return;

        Process temp = head;
        System.out.println("\n--- Final Process Stats ---");
        do {
            System.out.println("Process ID : " + temp.processId + ", Waiting Time : " + temp.waitingTime +
                               ", Turnaround Time : " + temp.turnaroundTime);
            totalWT += temp.waitingTime;
            totalTAT += temp.turnaroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.printf("Average Waiting Time : %.2f\n", (float)totalWT / count);
        System.out.printf("Average Turnaround Time : %.2f\n", (float)totalTAT / count);
    }
}

public class RoundRobinSchedulingAlgorithm {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Process ID, Burst Time, Priority :");
            int id = sc.nextInt();
            int bt = sc.nextInt();
            int p = sc.nextInt();
            scheduler.addProcess(id, bt, p);
        }

        System.out.print("Enter time quantum : ");
        int tq = sc.nextInt();

        scheduler.simulate(tq);
	}
}
