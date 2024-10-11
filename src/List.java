import java.util.Objects;

/**
 * @Author _se.ho
 * @create 2024-01-18
 **/
public class List {
    private ListNode head;

    /**
     * Constructor for objects of class List
     * Create a head
     */
    public List() {
        head = null;
    }

    public ListNode getHead() {
        return head;
    }

    /**
     * Add a new node at the start of a list
     *
     * @param data
     */
    public void addToList(String data) {
        ListNode newOne;

        newOne = new ListNode(data);
        newOne.setNext(head);

        head = newOne;
    }

    /**
     * Print the list, starting at head
     */
    public void printList() {
        ListNode marker;

        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("The list contains:");
            for (marker = head; marker != null; marker = marker.getNext()) {
                System.out.println(marker.printInfo());
            }
        }
    }

    /**
     * Deletes nodes containing the specified data from the linked list.
     *
     * @param data The data to be deleted from the list.
     */
    public void deleteFromList(String data) {
        ListNode marker, previous = null;

        for (marker = head; marker != null; previous = marker, marker = marker.getNext()) {
            if (Objects.equals(data, marker.getData()) && marker == head) {
                head = marker.getNext();
                break;
            } else if (Objects.equals(data, marker.getData())) {
                previous.setNext(marker.getNext());
                marker.setNext(null);
                break;
            }
        }
    }



    /**
     * Checks if the linked list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return Objects.equals(this.head, null);
    }
}
