import java.util.Scanner;
import java.util.ArrayList;

class User {
    int userID;
    String name;
    int age;
    ArrayList<Integer> friendIDs;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    // Add user to the list
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Get user by ID
    private User getUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // 1. Add a friend connection
    public void addFriend(int ID1, int ID2) {
        User user1 = getUserByID(ID1);
        User user2 = getUserByID(ID2);
        if (user1 == null || user2 == null) {
            System.out.println("User not found!");
            return;
        }
        if (!user1.friendIDs.contains(ID2)) {
            user1.friendIDs.add(ID2);
        }
        if (!user2.friendIDs.contains(ID1)) {
            user2.friendIDs.add(ID1);
        }
        System.out.println("Friend connection added.");
    }

    // 2. Remove a friend connection
    public void removeFriend(int ID1, int ID2) {
        User user1 = getUserByID(ID1);
        User user2 = getUserByID(ID2);
        if (user1 == null || user2 == null) {
            System.out.println("User not found!");
            return;
        }
        user1.friendIDs.remove(Integer.valueOf(ID2));
        user2.friendIDs.remove(Integer.valueOf(ID1));
        System.out.println("Friend connection removed.");
    }

    // 3. Find mutual friends
    public void findMutualFriends(int ID1, int ID2) {
        User user1 = getUserByID(ID1);
        User user2 = getUserByID(ID2);
        if (user1 == null || user2 == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("Mutual friends : ");
        for (int friend : user1.friendIDs) {
            if (user2.friendIDs.contains(friend)) {
                System.out.println("Friend ID : " + friend);
            }
        }
    }

    // 4. Display all friends of a user
    public void displayFriends(int userID) {
        User user = getUserByID(userID);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("Friends of " + user.name + " : ");
        for (int friendID : user.friendIDs) {
            System.out.println("Friend ID : " + friendID);
        }
    }

    // 5. Search by Name or User ID
    public void searchUser(String keyword) {
        boolean found = false;
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(keyword) || String.valueOf(temp.userID).equals(keyword)) {
                System.out.println("User found : ID = " + temp.userID + ", Name = " + temp.name + ", Age = " + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("User not found.");
        }
    }

    // 6. Count number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIDs.size() + " friend(s).");
            temp = temp.next;
        }
    }
}

public class SocialMediaFriendConnections {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();

        while (true) {
            System.out.println("\n--- Social Media Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display All Friends of User");
            System.out.println("6. Search User by Name or ID");
            System.out.println("7. Count Friends of Each User");
            System.out.println("8. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age : ");
                    int age = sc.nextInt();
                    sm.addUser(id, name, age);
                    break;

                case 2:
                    System.out.print("Enter User ID 1 : ");
                    int uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2 : ");
                    int uid2 = sc.nextInt();
                    sm.addFriend(uid1, uid2);
                    break;

                case 3:
                    System.out.print("Enter User ID 1 : ");
                    int rid1 = sc.nextInt();
                    System.out.print("Enter User ID 2 : ");
                    int rid2 = sc.nextInt();
                    sm.removeFriend(rid1, rid2);
                    break;

                case 4:
                    System.out.print("Enter User ID 1 : ");
                    int mid1 = sc.nextInt();
                    System.out.print("Enter User ID 2 : ");
                    int mid2 = sc.nextInt();
                    sm.findMutualFriends(mid1, mid2);
                    break;

                case 5:
                    System.out.print("Enter User ID : ");
                    int did = sc.nextInt();
                    sm.displayFriends(did);
                    break;

                case 6:
                    System.out.print("Enter Name or User ID to search : ");
                    String keyword = sc.nextLine();
                    sm.searchUser(keyword);
                    break;

                case 7:
                    sm.countFriends();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
	}
}
