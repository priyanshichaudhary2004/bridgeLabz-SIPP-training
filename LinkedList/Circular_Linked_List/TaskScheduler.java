import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskManager {
    private Task head = null;
    private Task current = null;

    public void addAtBeginning(int id, String name, int priority, String date) {
        Task newTask = new Task(id, name, priority, date);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head)
                temp = temp.next;
            newTask.next = head;
            head = newTask;
            temp.next = head;
        }
    }

    public void addAtEnd(int id, String name, int priority, String date) {
        Task newTask = new Task(id, name, priority, date);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addAtPosition(int id, String name, int priority, String date, int pos) {
        if (pos <= 1) {
            addAtBeginning(id, name, priority, date);
            return;
        }

        Task newTask = new Task(id, name, priority, date);
        Task temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeTaskById(int id) {
        if (head == null) return;

        Task curr = head, prev = null;
        do {
            if (curr.taskId == id) {
                if (curr == head) {
                    Task last = head;
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
                System.out.println("Task ID " + id + " removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task ID " + id + " not found.");
    }

    public void viewCurrentAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        if (current == null)
            current = head;

        System.out.println("Current Task:");
        displayTask(current);
        current = current.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task found with priority " + priority);
    }

    private void displayTask(Task task) {
        System.out.println("ID : " + task.taskId + ", Name : " + task.taskName +
                ", Priority : " + task.priority + ", Due Date : " + task.dueDate);
    }
}

public class TaskScheduler {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskManager scheduler = new TaskManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine(); 

            int id, priority, pos;
            String name, date;

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Priority, Due Date : ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    priority = sc.nextInt(); sc.nextLine();
                    date = sc.nextLine();
                    scheduler.addAtBeginning(id, name, priority, date);
                    break;
                case 2:
                    System.out.print("Enter ID, Name, Priority, Due Date : ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    priority = sc.nextInt(); sc.nextLine();
                    date = sc.nextLine();
                    scheduler.addAtEnd(id, name, priority, date);
                    break;
                case 3:
                    System.out.print("Enter ID, Name, Priority, Due Date, Position : ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    priority = sc.nextInt(); sc.nextLine();
                    date = sc.nextLine();
                    pos = sc.nextInt();
                    scheduler.addAtPosition(id, name, priority, date, pos);
                    break;
                case 4:
                    System.out.print("Enter Task ID to Remove : ");
                    id = sc.nextInt();
                    scheduler.removeTaskById(id);
                    break;
                case 5:
                    scheduler.viewCurrentAndMoveNext();
                    break;
                case 6:
                    scheduler.displayAllTasks();
                    break;
                case 7:
                    System.out.print("Enter Priority to Search : ");
                    priority = sc.nextInt();
                    scheduler.searchByPriority(priority);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
	}

}
