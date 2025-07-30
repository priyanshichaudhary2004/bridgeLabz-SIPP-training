import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketSystem {
    private Ticket head = null;

    // 1. Add new ticket at the end
    public void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket booked successfully.");
    }

    // 2. Remove ticket by Ticket ID
    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head, prev = null;

        do {
            if (current.ticketId == id) {
                if (current == head) {
                    Ticket last = head;
                    while (last.next != head)
                        last = last.next;

                    if (head.next == head) {
                        head = null;
                    } else {
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = current.next;
                }

                System.out.println("Ticket ID " + id + " cancelled.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket ID not found.");
    }

    // 3. Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No booked tickets.");
            return;
        }

        Ticket temp = head;
        System.out.println("\n--- Booked Tickets ---");
        do {
            System.out.println("Ticket ID : " + temp.ticketId +
                    ", Customer : " + temp.customerName +
                    ", Movie : " + temp.movieName +
                    ", Seat : " + temp.seatNumber +
                    ", Time : " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // 4. Search ticket by Customer or Movie Name
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        boolean found = false;
        Ticket temp = head;
        System.out.println("\n--- Search Results ---");
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID : " + temp.ticketId +
                        ", Customer : " + temp.customerName +
                        ", Movie : " + temp.movieName +
                        ", Seat : " + temp.seatNumber +
                        ", Time : " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No matching ticket found for '" + keyword + "'.");
        }
    }

    // 5. Count total tickets
    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class OnlineTicketReservation {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        TicketSystem system = new TicketSystem();
        int choice;

        do {
            System.out.println("\n--- Online Ticket Reservation System ---");
            System.out.println("1. Book New Ticket");
            System.out.println("2. Cancel Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer or Movie");
            System.out.println("5. Show Total Booked Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter choice : ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            int id;
            String name, movie, seat, time;

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID : ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Customer Name : ");
                    name = sc.nextLine();
                    System.out.print("Enter Movie Name : ");
                    movie = sc.nextLine();
                    System.out.print("Enter Seat Number : ");
                    seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to Cancel : ");
                    id = sc.nextInt();
                    system.removeTicket(id);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer or Movie Name to Search : ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;
                case 5:
                    System.out.println("Total Booked Tickets : " + system.countTickets());
                    break;
                case 0:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
