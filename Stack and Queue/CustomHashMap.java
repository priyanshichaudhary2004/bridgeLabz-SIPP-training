import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CustomHashMap {

    // Node class to represent key-value pairs
    static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 100; // Size of bucket array
    private Node[] buckets;

    public CustomHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function
    private int getIndex(int key) {
        return key % SIZE;
    }

    // Insert or update key-value pair
    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = buckets[index];

        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    // Retrieve value
    public Integer get(int key) {
        int index = getIndex(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key == key)
                return current.value;
            current = current.next;
        }

        return null;
    }

    // Remove key
    public void remove(int key) {
        int index = getIndex(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }

            prev = current;
            current = current.next;
        }
    }

    // Print all key-value pairs
    public void printMap() {
        System.out.println("Current HashMap contents : ");
        for (int i = 0; i < SIZE; i++) {
            Node node = buckets[i];
            while (node != null) {
                System.out.println("Key : " + node.key + ", Value : " + node.value);
                node = node.next;
            }
        }
    }

    public static void main(String[] args) throws IOException {
    	// TODO Auto-generated method stub
        CustomHashMap map = new CustomHashMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Put (Insert/Update)");
            System.out.println("2. Get");
            System.out.println("3. Remove");
            System.out.println("4. Print HashMap");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter key (int) : ");
                    int keyPut = Integer.parseInt(br.readLine());
                    System.out.print("Enter value (int) : ");
                    int valuePut = Integer.parseInt(br.readLine());
                    map.put(keyPut, valuePut);
                    System.out.println("Inserted/Updated.");
                    break;

                case 2:
                    System.out.print("Enter key to get value : ");
                    int keyGet = Integer.parseInt(br.readLine());
                    Integer value = map.get(keyGet);
                    if (value != null)
                        System.out.println("Value : " + value);
                    else
                        System.out.println("Key not found.");
                    break;

                case 3:
                    System.out.print("Enter key to remove : ");
                    int keyRemove = Integer.parseInt(br.readLine());
                    map.remove(keyRemove);
                    System.out.println("Key removed if it existed.");
                    break;

                case 4:
                    map.printMap();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
