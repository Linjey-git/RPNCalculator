import java.util.Date;

/**
 * @Author _se.ho
 * @create 2024-01-23
 **/

public class Stack {

    private List stack;

    /**
     * Constructs a new Stack.
     */
    public Stack() {
        this.stack = new List();
    }

    /**
     * Pushes a new node with the specified data onto the stack.
     *
     * @param data The data value to be pushed onto the stack.
     */
    public void push(String data) {
        stack.addToList(data);
    }

    /**
     * Prints the contents of the stack.
     */
    public void print() {
        stack.printList();
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return The data of the top element that was removed, or null if the stack is empty.
     */
    public String pop() {
        if (isEmpty()) {
            return null;
        } else {
            String data = getTop().getData();
            stack.deleteFromList(data);
            return data;
        }
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Gets the top node of the stack.
     *
     * @return The top node of the stack.
     */
    private ListNode getTop() {
        return stack.getHead();
    }

}

