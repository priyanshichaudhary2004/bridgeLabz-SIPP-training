import java.util.Scanner;

class TextState {
    String text;
    TextState prev;
    TextState next;

    TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState current;
    private int size;
    private final int MAX_HISTORY = 10;

    public TextEditor() {
        head = null;
        current = null;
        size = 0;
    }

    // 1. Add new state
    public void addState(String newText) {
        TextState newState = new TextState(newText);
        if (head == null) {
            head = newState;
            current = newState;
            size = 1;
        } else {
            // Remove all redo states
            current.next = null;

            // Link new state
            newState.prev = current;
            current.next = newState;
            current = newState;
            size++;

            // Remove oldest state if size > MAX_HISTORY
            if (size > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
        System.out.println("State added.");
    }

    // 2. Undo
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // 3. Redo
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    // 4. Display current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text : " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }
}

public class TextEditorApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Add Text State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");
            System.out.print("Enter choice : ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text : ");
                    String newText = sc.nextLine();
                    editor.addState(newText);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
	}
}
