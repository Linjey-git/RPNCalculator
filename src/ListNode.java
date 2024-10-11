/**
 * @Author _se.ho
 * @create 2024-01-18
 **/
public class ListNode {

    private String data;
    private ListNode next;

    /**
     * Constructs a new ListNode with the specified data.
     *
     * @param data The data value for the new node.
     */
    public ListNode(String data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Get the next node
     *
     * @return the next node
     */
    public ListNode getNext() {
        return next;
    }


    /**
     * Set the next node
     *
     * @param next the node to be added at this node's next
     */
    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * Gets the data value stored in this node.
     *
     * @return The data value of the node.
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the data value for this node.
     *
     * @param data The new data value to be set.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Returns a formatted string containing the data from this node.
     *
     * @return A string with the formatted node information.
     */
    public String printInfo() {
        String info = "data = " + data;
        return info;
    }
}
