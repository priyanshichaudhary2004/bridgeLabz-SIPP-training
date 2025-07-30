import java.util.Scanner;

class ItemNode {
	String itemName;
	int itemID, quantity;
	double price;
	ItemNode next;
	
	ItemNode(String itemName, int itemID, int quantity, double price) {
		this.itemName = itemName;
		this.itemID = itemID;
		this.quantity = quantity;
		this.price = price;
		this.next = null;
	}
}

class InventoryLinkedList {
	ItemNode head;
	
	//Add at beginning
	public void addAtBeginning(String name, int ID, int qty, double price) {
		ItemNode newNode = new ItemNode(name, ID, qty, price);
		newNode.next = head;
		head = newNode;
	}
	
	//Add at end
	public void addAtEnd(String name, int ID, int qty, double price) {
		ItemNode newNode = new ItemNode(name, ID, qty, price);
		if(head == null) {
			head = newNode;
			return;
		}
		ItemNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	//Add at position
	public void addAtPosition(String name, int ID, int qty, double price, int position) {
		if(position == 1) {
			addAtBeginning(name, ID, qty, price);
			return;
		}
		ItemNode newNode = new ItemNode(name, ID, qty, price);
		ItemNode temp = head;
		for(int i = 1; i < position - 1 && temp != null; i++) {
			temp = temp.next;
		}
		if(temp == null) {
			System.out.println("Invalid position.");
			return;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	//Remove by ID 
	public void removeByID(int ID) {
		if(head == null) {
			return;
		}
		if(head.itemID == ID) {
			head = head.next;
			return;
		}
		ItemNode temp = head;
		while(temp.next != null && temp.next.itemID != ID) {
			temp = temp.next;
		}
		if(temp.next == null) {
			System.out.println("Item not found.");
		} else {
			temp.next = temp.next.next;
		}
	}
	
	//Update quantity
	public void updateQuantity(int ID, int newQty) {
		ItemNode temp = head;
		while(temp != null) {
			if(temp.itemID == ID) {
				temp.quantity = newQty;
				return;
			}
			temp = temp.next;
		}
		System.out.println("Item not found.");
	}
	
	//Search by ID or Name
	public void search(String keyword) {
		ItemNode temp = head;
		boolean found = false;  
		while(temp != null) {
			if(String.valueOf(temp.itemID).equals(keyword) || temp.itemName.equalsIgnoreCase(keyword)) {
				System.out.println("Found : " + temp.itemName + " , ID : " + temp.itemID + " , Qty : " + temp.quantity + " , Price : " + temp.price);
				found = true;
			}
			temp = temp.next;
		}
		if(!found) {
			System.out.println("Item not found.");
		}
	}
	
	//Total inventory value
	public void totalInventoryValue() {
		double total = 0;
		ItemNode temp = head;
		while(temp != null) {
			total += temp.quantity * temp.price;
			temp = temp.next;
		}
		System.out.println("Total Inventory Value = Rs." + total);
	}
	
	//Display List
	public void display() {
		if(head == null) {
			System.out.println("Inventory is empty.");
			return;
		}
		ItemNode temp = head;
		System.out.println("Inventory : ");
		while(temp != null) {
			System.out.println("Name : " + temp.itemName + " , ID : " + temp.itemID + " , Qty : " + temp.quantity + " , Price : " + temp.price);
			temp = temp.next;
		}
	}
	
	//Merge Sort by Item Name
	public ItemNode mergeSort(ItemNode head, String criteria, boolean ascending) {
        if (head == null || head.next == null) {
        	return head;
        }

        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(head, criteria, ascending);
        ItemNode right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }
	
	private ItemNode getMiddle(ItemNode head) {
        if (head == null) {
        	return head;
        }
        ItemNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
	
	private ItemNode sortedMerge(ItemNode a, ItemNode b, String criteria, boolean ascending) {
        if (a == null) {
        	return b;
        }
        if (b == null) {
        	return a;
        }

        boolean condition;
        if (criteria.equalsIgnoreCase("name")) {
        	condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) < 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } 
        else {
        	condition = ascending ? a.price < b.price : a.price > b.price;
        }

        ItemNode result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, criteria, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, criteria, ascending);
        }
        return result;
    }
	
	public void sortInventory(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
    }
}


public class InventoryManagementSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		InventoryLinkedList inventory = new InventoryLinkedList();
        int choice;

        do {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item by ID");
            System.out.println("3. Update Quantity by ID");
            System.out.println("4. Search Item (by ID or Name)");
            System.out.println("5. Display Inventory");
            System.out.println("6. Total Inventory Value");
            System.out.println("7. Sort Inventory");
            System.out.println("8. Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();  

            String name;
            int ID, qty, pos;
            double price;

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name : ");
                    name = sc.nextLine();
                    System.out.print("Enter Item ID : ");
                    ID = sc.nextInt();
                    System.out.print("Enter Quantity : ");
                    qty = sc.nextInt();
                    System.out.print("Enter Price : ");
                    price = sc.nextDouble();
                    System.out.print("1. Beginning  2. End  3. Specific Position : ");
                    int loc = sc.nextInt();
                    if (loc == 1)
                        inventory.addAtBeginning(name, ID, qty, price);
                    else if (loc == 2)
                        inventory.addAtEnd(name, ID, qty, price);
                    else {
                        System.out.print("Enter position : ");
                        pos = sc.nextInt();
                        inventory.addAtPosition(name, ID, qty, price, pos);
                    }
                    break;

                case 2:
                    System.out.print("Enter Item ID to remove : ");
                    ID = sc.nextInt();
                    inventory.removeByID(ID);
                    break;

                case 3:
                    System.out.print("Enter Item ID to update quantity : ");
                    ID = sc.nextInt();
                    System.out.print("Enter new quantity : ");
                    qty = sc.nextInt();
                    inventory.updateQuantity(ID, qty);
                    break;

                case 4:
                    System.out.print("Enter Item ID or Name to search : ");
                    String keyword = sc.nextLine();
                    inventory.search(keyword);
                    break;

                case 5:
                    inventory.display();
                    break;

                case 6:
                    inventory.totalInventoryValue();
                    break;

                case 7:
                    System.out.print("Sort by (name/price) : ");
                    String criteria = sc.nextLine();
                    System.out.print("Order (asc/desc) : ");
                    String order = sc.nextLine();
                    boolean asc = order.equalsIgnoreCase("asc");
                    inventory.sortInventory(criteria, asc);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);
	}
}
